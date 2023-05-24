package org.kafka.producer.wikimedia.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
	
	@Bean
	public NewTopic wikimediatopic() {
		return TopicBuilder.name("wikimedia_changes")
				.build();		
	}
	@Bean
	public NewTopic infJsonTopic() {
		return TopicBuilder.name("inf_Json")
				.build();		
	}
}
