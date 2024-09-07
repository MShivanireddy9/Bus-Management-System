package com.tcs.payments.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tcs.payments.event.PaymentEvent;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.jms.connection.CachingConnectionFactory;
//import org.springframework.jms.core.JmsTemplate;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.jms.support.destination.DynamicDestinationResolver;

import java.util.LinkedList;
import java.util.Queue;
//import jakarta.jms.Session;
@Configuration
public class JmsConfig {

//    private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";
//    private static final String DEFAULT_USERNAME = "admin";
//    private static final String DEFAULT_PASSWORD = "admin";
//
//    @Bean
//    public ActiveMQConnectionFactory connectionFactory() {
//        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
//        connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
//        connectionFactory.setUserName(DEFAULT_USERNAME);
//        connectionFactory.setPassword(DEFAULT_PASSWORD);
//        return connectionFactory;
//    }
    @Bean
    public String myStringBean() {
        return "kafka";
    }
//    @Bean
//    public JmsTemplate jmsTemplate() {
//        JmsTemplate jmsTemplate = new JmsTemplate();
//        jmsTemplate.setConnectionFactory(connectionFactory());
//        jmsTemplate.setDestinationResolver(new DynamicDestinationResolver());
//        jmsTemplate.setMessageConverter(messageConverter());
//        jmsTemplate.setDefaultDestinationName("myDefaultDestination");
//        return jmsTemplate;
//    }
//
//    @Bean
//    public MessageConverter messageConverter() {
//        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
//        converter.setTargetType(MessageType.TEXT);
//        converter.setTypeIdPropertyName("_type");
//        return converter;
//    }
	@Bean
    public Queue<PaymentEvent> paymentEventQueue() {
        return new LinkedList<>();
    }
}
