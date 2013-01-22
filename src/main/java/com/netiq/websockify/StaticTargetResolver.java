package com.netiq.websockify;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Random;

import org.jboss.netty.channel.Channel;

public class StaticTargetResolver implements IProxyTargetResolver {

    private InetSocketAddress targetAddress;
    private InetSocketAddress targetAddress2;

    public StaticTargetResolver(String targetHost, int targetPort) {
        targetAddress = new InetSocketAddress(targetHost, targetPort);
        targetAddress2 = new InetSocketAddress("192.168.1.193", 5900);
    }

    public InetSocketAddress resolveTarget(Channel channel) {
        System.out.println(channel);
        InetSocketAddress localAddress = (InetSocketAddress) channel.getLocalAddress();
        System.out.println(localAddress);
        System.out.println(channel.getRemoteAddress());
        int i = new Random().nextInt(2);
        if (WebsockifyProxyHandler.path.contains("linux")) {
            return targetAddress2;
        }
        return targetAddress;
    }

}
