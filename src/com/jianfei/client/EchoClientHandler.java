package com.jianfei.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-09-20 09:21
 */
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
    /**
     * 向服务端发送数据
     */
    @Override
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        System.out.println("客户端与服务端通道-开启：" + channelHandlerContext.channel().localAddress() + "channelActive");

        String sendInfo = "Hello 这里是客户端  你好啊！第二次发送";
        System.out.println("客户端准备发送的数据包：" + sendInfo);
        channelHandlerContext.writeAndFlush(Unpooled.copiedBuffer(sendInfo, CharsetUtil.UTF_8)); // 必须有flush

    }

    /**
     * channelInactive
     *
     * channel 通道 Inactive 不活跃的
     *
     * 当客户端主动断开服务端的链接后，这个通道就是不活跃的。也就是说客户端与服务端的关闭了通信通道并且不可以传输数据
     *
     */
    @Override
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        System.out.println("客户端与服务端通道-关闭：" + channelHandlerContext.channel().localAddress() + "channelInactive");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        System.out.println("读取客户端通道信息..");
        ByteBuf buf = byteBuf.readBytes(byteBuf.readableBytes());
        System.out.println("客户端接收到的服务端信息:" + ByteBufUtil.hexDump(buf) + "; 数据包为:" + buf.toString(Charset.forName("utf-8")));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable cause) throws Exception {
        channelHandlerContext.close();
        System.out.println("异常退出:" + cause.getMessage());
    }
}
