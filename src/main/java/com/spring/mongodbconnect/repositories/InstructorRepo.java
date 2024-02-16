package com.spring.mongodbconnect.repositories;

import com.spring.mongodbconnect.models.Instructor;
import com.spring.mongodbconnect.models.Tutorial;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepo extends MongoRepository<Instructor, String> {
    List<Instructor> findByName(final String name);

}
