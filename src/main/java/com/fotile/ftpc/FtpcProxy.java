package com.fotile.ftpc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;

import com.datasweep.compatibility.client.DatasweepException;
import com.datasweep.compatibility.client.ServerInfo;
import com.datasweep.plantops.common.exceptions.DatasweepProxyException;
import com.datasweep.plantops.proxies.ProxyFactory;

@ConfigurationProperties(prefix = "mes.ftpc")
public class FtpcProxy {
	
	private String userName;
	
	private String password;
	
	private static String iiopUrl; 
	private static String httpUrl;
	private static final String APP_SERVER_NAME = "JBoss";
	
	@Autowired
	private ServerInfo serverInfo;

	public WebObjectFactory login() throws DatasweepProxyException, DatasweepException{
		System.setProperty(ProxyFactory.J2EE_VENDOR_SYSTEM_PROPERTY, APP_SERVER_NAME);
		WebObjectFactory webObjectFactory = new WebObjectFactory(serverInfo);
		webObjectFactory.login(userName, password);
		return webObjectFactory;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public static String getIiopUrl() {
		return iiopUrl;
	}


	public static void setIiopUrl(String iiopUrl) {
		FtpcProxy.iiopUrl = iiopUrl;
	}


	public static String getHttpUrl() {
		return httpUrl;
	}


	public static void setHttpUrl(String httpUrl) {
		FtpcProxy.httpUrl = httpUrl;
	}


	public ServerInfo getServerInfo() {
		return serverInfo;
	}


	public void setServerInfo(ServerInfo serverInfo) {
		this.serverInfo = serverInfo;
	}


}
