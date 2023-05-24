package org.kafka.consumer.database.repository;

import org.kafka.consumer.database.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikiRepository extends JpaRepository<WikimediaData, Long>{

}
