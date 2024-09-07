package com.tcs.payments.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcs.payments.event.PaymentEvent;

@Component
public class CustomMessageConverter implements MessageConverter {
    private final ObjectMapper objectMapper;

    public CustomMessageConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Message toMessage(Object object, org.springframework.amqp.core.MessageProperties messageProperties) {
        try {
            byte[] bytes = objectMapper.writeValueAsBytes(object);
            return MessageBuilder.withBody(bytes)
                    .copyProperties(messageProperties)
                    .build();
        } catch (Exception e) {
            throw new IllegalArgumentException("Error converting object to message", e);
        }
    }

    @Override
    public Object fromMessage(org.springframework.amqp.core.Message message) {
        try {
            return objectMapper.readValue(message.getBody(), PaymentEvent.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error converting message to object", e);
        }
    }
    
}
