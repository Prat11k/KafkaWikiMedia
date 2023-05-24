package org.kafka.consumer.database.service;

import org.kafka.consumer.database.entity.WikimediaData;
import org.kafka.consumer.database.repository.WikiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsume {

	private static final Logger logger = LoggerFactory.getLogger(KafkaDatabaseConsume.class);
	@Autowired
	private WikiRepository wikiRepository;
	@KafkaListener(topics = "wikimedia_changes", groupId="myGroup")
	public void consume(String eventMessage) {
		logger.info(String.format("Message Received -> %s", eventMessage));
		WikimediaData wikimediaData = new WikimediaData();
		wikimediaData.setWikiEventData(eventMessage);
		wikiRepository.save(wikimediaData);
	}
}
