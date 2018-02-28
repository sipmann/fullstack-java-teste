package br.com.lemontech.config;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.lemontech.utils.SysOpts;

@Configuration
public class RabbitConfiguration {
	@Bean
	public ConnectionFactory connectionFactory() {
		String rabbit = SysOpts.env("RABBITHOST", "");
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(rabbit);
		return connectionFactory;
	}

	@Bean
	public AmqpAdmin amqpAdmin() {
		return new RabbitAdmin(connectionFactory());
	}

	@Bean
	public RabbitTemplate rabbitTemplate() {
		return new RabbitTemplate(connectionFactory());
	}

	@Bean
	public Queue myQueue() {
		return new Queue(Constants.VIAGEM_LISTA);
	}

	@Bean(name="rabbitListenerContainerFactory")
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerlistenerFactory() {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		factory.setPrefetchCount(1);
		factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
		return factory;
	}
}
