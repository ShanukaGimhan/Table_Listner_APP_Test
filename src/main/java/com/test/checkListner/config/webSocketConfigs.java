package com.test.checkListner.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class webSocketConfigs implements	WebSocketMessageBrokerConfigurer {

@Override
public void registerStompEndpoints(StompEndpointRegistry registry) {
	registry.addEndpoint("/websocket").withSockJS();
}

@Override
public void configureMessageBroker(org.springframework.messaging.simp.config.MessageBrokerRegistry config) {
	config.enableSimpleBroker("/topic");
	config.setApplicationDestinationPrefixes("/app");
}

}