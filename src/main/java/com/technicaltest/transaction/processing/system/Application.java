package com.technicaltest.transaction.processing.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application  {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@KafkaListener(topics = "devs4j-topic", containerFactory = "listenerContainerFactory",
			groupId = "devs4j-group",  properties ={"max.poll.interval.ms:4000","max.poll.records:10"})
	public void listen(String messages){
		log.info("Init: {}", messages);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
