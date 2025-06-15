
package com.agent.config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("!test")	// Exclude this from DemoAuthorizationServerApplicationTests and DemoAuthorizationServerConsentTests
@Configuration(proxyBeanMethods = false)
public class TomcatServerConfig {

	@Bean
	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> connectorCustomizer() {
		return (tomcat) -> tomcat.addAdditionalTomcatConnectors(createHttpConnector());
	}

	private Connector createHttpConnector() {
		Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
		connector.setScheme("http");
		connector.setPort(19000);
		connector.setSecure(false);
		connector.setRedirectPort(9443);
		return connector;
	}

}
