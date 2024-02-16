package com.spring.mongodbconnect.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "tutorial")
@ToString(exclude = {"idNum"})
public class Tutorial {
    @Id
    private int idNum;

    private String name;
    private String instructorName;
    private List<Lesson> lessons;
    private List<Tag> tags;
    public Tutorial(final String instructorName, final List<Lesson> lessons, final List<Tag> tags){
        this.instructorName= instructorName;
        this.lessons = lessons;
        this.tags=tags;
    }
}
