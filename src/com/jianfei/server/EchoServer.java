package com.jianfei.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.codec.string.StringEncoder;

import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-09-20 08:58
 */
public class EchoServer {
    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void start() throws Exception {
        EventLoopGroup parentEventLoopGroup = new NioEventLoopGroup();
        EventLoopGroup childEventLoopGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.option(ChannelOption.SO_BACKLOG, 1024);
            serverBootstrap.group(parentEventLoopGroup, childEventLoopGroup) // 绑定线程池
                    .channel(NioServerSocketChannel.class) // 指定使用的channel
                    .localAddress(this.port)// 绑定监听端口
                    .childHandler(new ChannelInitializer<SocketChannel>() { // 绑定客户端连接时候触发操作

                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            System.out.println("报告");
                            System.out.println("信息：有一客户端链接到本服务端");
                            System.out.println("IP:" + socketChannel.localAddress().getHostName());
                            System.out.println("Port:" + socketChannel.localAddress().getPort());
                            System.out.println("报告完毕");

                            socketChannel.pipeline().addLast(new StringEncoder(Charset.forName("GBK")));
                            socketChannel.pipeline().addLast(new EchoServerHandler()); // 客户端触发操作
                            socketChannel.pipeline().addLast(new ByteArrayEncoder());
                        }
                    });
            ChannelFuture channelFuture = serverBootstrap.bind().sync(); // 服务器异步创建绑定
            System.out.println(EchoServer.class + " 启动正在监听： " + channelFuture.channel().localAddress());
            channelFuture.channel().closeFuture().sync(); // 关闭服务器通道
        } finally {
            parentEventLoopGroup.shutdownGracefully().sync(); // 释放线程池资源
            childEventLoopGroup.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws Exception {
        EchoServer echoServer = new EchoServer(8888);
        echoServer.start(); // 启动
        /*Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.next();
            System.out.println("-------->" + input);
        }*/
    }
}
