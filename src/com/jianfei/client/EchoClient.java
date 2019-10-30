package com.jianfei.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-09-20 09:20
 */
public class EchoClient {
    private final String host;
    private final int port;
    private static Channel channel;

    public EchoClient() {
        this(0);
    }

    public EchoClient(int port) {
        this("localhost", port);
    }

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws Exception {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup) // 注册线程池
                    .channel(NioSocketChannel.class) // 使用NioSocketChannel来作为连接用的channel类
                    .remoteAddress(new InetSocketAddress(this.host, this.port)) // 绑定连接端口和host信息
                    .handler(new ChannelInitializer<SocketChannel>() { // 绑定连接初始化器
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            System.out.println("正在连接中...");
                            socketChannel.pipeline().addLast(new StringEncoder(Charset.forName("GBK")));
                            socketChannel.pipeline().addLast(new EchoClientHandler());
                            socketChannel.pipeline().addLast(new ByteArrayEncoder());
                            socketChannel.pipeline().addLast(new ChunkedWriteHandler());

                        }
                    });
            // System.out.println("服务端连接成功..");

            ChannelFuture channelFuture = bootstrap.connect().sync(); // 异步连接服务器
            System.out.println("服务端连接成功..."); // 连接完成

            channel = channelFuture.channel();
            channel.closeFuture().sync(); // 异步等待关闭连接channel
            System.out.println("连接已关闭.."); // 关闭完成

        } finally {
            eventLoopGroup.shutdownGracefully().sync(); // 释放线程池资源
        }
    }

    public static void main(String[] args) throws Exception {
        new EchoClient("127.0.0.1", 8888).start(); // 连接127.0.0.1/65535，并启动
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            if (input != null && !input.equals("")) {
                System.out.println("scanner->" + input);
                channel.writeAndFlush(input);
            }
        }
    }
}
