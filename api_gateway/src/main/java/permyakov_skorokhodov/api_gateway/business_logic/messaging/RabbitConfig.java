package permyakov_skorokhodov.api_gateway.business_logic.messaging;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String MAIL_NOTIFICATIONS_QUEUE = "emailQueue";

    public static final String SMS_NOTIFICATIONS_QUEUE = "smsQueue";

    public static final String NOTIFICATIONS_EXCHANGE = "notifications-exchange";

    @Bean
    public Queue mailNotificationsQueue() {
        return new Queue(MAIL_NOTIFICATIONS_QUEUE, false);
    }

    @Bean
    public Queue smsNotificationsQueue() {
        return new Queue(SMS_NOTIFICATIONS_QUEUE, false);
    }

    @Bean
    public DirectExchange notificationsExchange() {
        return new DirectExchange(NOTIFICATIONS_EXCHANGE);
    }

    @Bean
    public Binding bindingMailNotificationsQueue() {
        return BindingBuilder.bind(mailNotificationsQueue())
                .to(notificationsExchange()).with(MAIL_NOTIFICATIONS_QUEUE);
    }

    @Bean
    public Binding bindingSmsNotificationsQueue() {
        return BindingBuilder.bind(smsNotificationsQueue())
                .to(notificationsExchange()).with(SMS_NOTIFICATIONS_QUEUE);
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("rabbitmq");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }
}
