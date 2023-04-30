package ru.tinkoff.edu.java.bot.configuration;

import org.openapitools.model.LinkUpdateRequest;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.ClassMapper;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConditionalOnProperty(prefix = "app", name = "use-queue", havingValue = "true")
public class RabbitMQConfig {
    @Value("${app.queue-name}")
    private String queueName;
    @Value("${app.exchange-name}")
    private String exchangeName;

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(exchangeName, false, false);
    }

    @Bean
    public Queue queue() {
        return QueueBuilder.nonDurable(queueName).withArgument("x-dead-letter-exchange", exchangeName + ".dlx").build();
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(directExchange()).with(queueName);
    }

    @Bean
    public FanoutExchange deadDirectExchange() {
        return new FanoutExchange(exchangeName + ".dlx", false, false);
    }

    @Bean
    public Queue deadQueue() {
        return QueueBuilder.nonDurable(queueName + ".dlq").build();
    }

    @Bean
    public Binding deadBinding() {
        return BindingBuilder.bind(deadQueue()).to(deadDirectExchange());
    }

    @Bean
    public ClassMapper classMapper(){
        Map<String, Class<?>> mappings = new HashMap<>();
        mappings.put("ru.tinkoff.edu.java.scrapper.client.dto.LinkUpdateRequest", LinkUpdateRequest.class);

        DefaultClassMapper classMapper = new DefaultClassMapper();
        classMapper.setTrustedPackages("ru.tinkoff.edu.java.scrapper.client.dto.*");
        classMapper.setIdClassMapping(mappings);
        return classMapper;
    }

    @Bean
    public MessageConverter jsonMessageConverter(ClassMapper classMapper){
        Jackson2JsonMessageConverter jsonConverter=new Jackson2JsonMessageConverter();
        jsonConverter.setClassMapper(classMapper);
        return jsonConverter;
    }
}