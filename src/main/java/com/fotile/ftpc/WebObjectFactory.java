package com.fotile.ftpc;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.datasweep.compatibility.client.DatasweepException;
import com.datasweep.compatibility.client.ServerInfo;
import com.datasweep.compatibility.client.User;
import com.datasweep.compatibility.manager.ServerImpl;
import com.datasweep.compatibility.manager.SiteCache;
import com.datasweep.plantops.common.exceptions.DatasweepProxyException;
import com.datasweep.plantops.proxies.ProxyFactory;


@ConfigurationProperties(prefix = "mes.WebObjectFactory")
public class WebObjectFactory extends ServerImpl{
	public WebObjectFactory(ServerInfo serverInfo) throws DatasweepProxyException{
		super(serverInfo);
		int siteNumber = getDBInfo().getSiteNumber();
		setSiteCache(new SiteCache(siteNumber));
		getProxyFactory().setClientType(ProxyFactory.CLIENT_TYPE_THIN);
		setDefaultServer(this);
	}

	@Override
	public User login(String userName, String password) throws DatasweepException {
		// TODO Auto-generated method stub
		return super.login(userName, password);
		
	}

	
}
