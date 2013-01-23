package com.netiq.websockify;

import java.net.InetAddress;
import java.net.InetSocketAddress;

import org.jboss.netty.channel.Channel;

public class StaticTargetResolver implements IProxyTargetResolver {
	
    private String targetHost;
    private int targetPort;

    public StaticTargetResolver ( String targetHost, int targetPort )
	{
        this.targetHost = targetHost;
        this.targetPort = targetPort;
    }

	public InetSocketAddress resolveTarget(Channel channel) {
		return new InetSocketAddress ( targetHost, targetPort );
	}

}
