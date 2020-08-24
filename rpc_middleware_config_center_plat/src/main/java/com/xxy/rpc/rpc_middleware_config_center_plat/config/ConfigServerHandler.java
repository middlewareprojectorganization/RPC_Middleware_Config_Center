package com.xxy.rpc.rpc_middleware_config_center_plat.config;

import com.xxy.rpc.rpc_middleware_config_center_plat.common.ConfigPushAction;
import com.xxy.rpc.rpc_middleware_config_center_plat.common.ConfigTypeEnum;
import com.xxy.rpc.rpc_middleware_config_center_plat.entity.ConfigInfo;
import com.xxy.rpc.rpc_middleware_config_center_plat.request.ConfigRequest;
import com.xxy.rpc.rpc_middleware_config_center_plat.request.RpcRequest;
import com.xxy.rpc.rpc_middleware_config_center_plat.service.ConfigInfoService;
import com.xxy.rpc.rpc_middleware_config_center_plat.util.SpringUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: XXY
 * @Date: 2020/8/21 0:49
 */
public class ConfigServerHandler extends SimpleChannelInboundHandler<ConfigRequest> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigServerHandler.class);

    /**
     * 心跳机制触发
     * @param ctx
     * @param evt
     * @throws Exception
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ConfigRequest configRequest) throws Exception {
        LOGGER.info("客户端获取配置请求:{}", configRequest);
        //此处处理客户端请求推送配置
        sendConfig(configRequest.getConfigTypeEnum(), channelHandlerContext.channel(), ConfigPushAction.GET);
    }

    public void sendConfig(ConfigTypeEnum configTypeEnum, Channel channel, ConfigPushAction configPushAction){
        //获取当前配置
        if(ConfigTypeEnum.GLOBAL.equals(configTypeEnum)){
            //推送全局配置
            SpringUtil.getApplicationContext().getBean(ConfigInfoService.class)

        }else {
            //TODO
        }
    }
}
