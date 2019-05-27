package com.fotile.ftpc;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.datasweep.compatibility.client.DatasweepException;
import com.datasweep.plantops.common.exceptions.DatasweepProxyException;
import com.fotile.MesApplicationTests;

@EnableConfigurationProperties(FtpcProxy.class)
public class FtpcTest extends MesApplicationTests{
	@Autowired
	FtpcProxy ftpcProxy;
	@Test
	public void testLogin() throws DatasweepProxyException, DatasweepException{
		WebObjectFactory webObjectFactory = ftpcProxy.login();
		System.err.println(webObjectFactory.getUserManager().getCurrentUser().getDescription());
	}
	
	@Test
	public void test(){
		System.out.println(ftpcProxy.getUserName());
//		System.err.println(ftpcProxy.getIiopUrl());
//		System.err.println(ftpcProxy.getHttpUrl());
		System.out.println(ftpcProxy.getServerInfo().getIiopURL());
	}

}
