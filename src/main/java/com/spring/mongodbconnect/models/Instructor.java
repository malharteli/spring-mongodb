package com.spring.mongodbconnect.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "instructors")
@ToString(exclude = {"id"})
public class Instructor {
    @Id private String id;
    private String name;
    private List<Tutorial> tutorials;
    public Instructor(final String name, final List<Tutorial> tutorials){
        this.name=name;
        this.tutorials=tutorials;
    }
}
