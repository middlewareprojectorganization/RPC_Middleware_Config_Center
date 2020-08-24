package com.xxy.rpc.rpc_middleware_config_center_plat.config;

import com.xxy.rpc.rpc_middleware_config_center_plat.request.RpcRequest;
import com.xxy.rpc.rpc_middleware_config_center_plat.response.RpcResponse;
import com.xxy.rpc.rpc_middleware_config_center_plat.serializer.Hessian1Serializer;
import com.xxy.rpc.rpc_middleware_config_center_plat.serializer.NettyDecoder;
import com.xxy.rpc.rpc_middleware_config_center_plat.serializer.NettyEncoder;
import com.xxy.rpc.rpc_middleware_config_center_plat.serializer.Serializer;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class ConfigServerHandlerInitializer extends ChannelInitializer<Channel> {
    private Serializer serializer = new Hessian1Serializer();
    @Override
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline()
                //空闲检测
                .addLast(new  IdleStateHandler(60, 45, 20, TimeUnit.SECONDS))
                .addLast(new NettyDecoder(RpcRequest.class, serializer))
                .addLast(new NettyEncoder(RpcResponse.class, serializer))
                .addLast(new ConfigServerHandler());
    }
}
