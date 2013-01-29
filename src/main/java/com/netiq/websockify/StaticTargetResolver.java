package com.netiq.websockify;

import java.net.InetSocketAddress;

import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.MessageEvent;

public class StaticTargetResolver implements IProxyTargetResolver {
	
    private String targetHost;
    private int targetPort;

    public StaticTargetResolver ( String targetHost, int targetPort )
	{
        this.targetHost = targetHost;
        this.targetPort = targetPort;
    }

	public InetSocketAddress resolveTarget(MessageEvent messageEvent) {
		return new InetSocketAddress ( targetHost, targetPort );
	}

}
