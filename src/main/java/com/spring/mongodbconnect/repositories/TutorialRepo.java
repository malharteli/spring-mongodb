package com.spring.mongodbconnect.repositories;

import com.spring.mongodbconnect.models.Tutorial;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepo extends MongoRepository<Tutorial, String> {
    List<Tutorial> findTutorialByName(final String name);

    @Query("{'tags': ?0}")
    List<Tutorial> findByTag(final String tag);
}
