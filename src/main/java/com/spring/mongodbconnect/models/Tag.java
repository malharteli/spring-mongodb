package com.spring.mongodbconnect.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Tag {
    private String name;
    public Tag(final String name){
        this.name=name;
    }
}
