package com.topal.application.config;

import feign.RequestInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
//import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@EnableOAuth2Client
@EnableConfigurationProperties
@Configuration
public class OAuth2ClientConfig {

	@Bean
	@ConfigurationProperties(prefix = "security.oauth2.client")
	public ClientCredentialsResourceDetails clientCredentialsResourceDetails() {
		return new ClientCredentialsResourceDetails();
	}

	@Bean
	public RequestInterceptor oauth2FeignRequestInterceptor() {
		return new OAuth2FeignRequestInterceptor();
	}

	@Bean
	public OAuth2RestTemplate oAuth2RestTemplate() {
		ClientCredentialsResourceDetails resourceDetails = clientCredentialsResourceDetails();
		resourceDetails.setGrantType("client_credentials");
		OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(resourceDetails, new DefaultOAuth2ClientContext());
		oAuth2RestTemplate.setRequestFactory(new SimpleClientHttpRequestFactory());//Netty4ClientHttpRequestFactory());//SimpleClientHttpRequestFactory
		return  oAuth2RestTemplate;	
	}

}
