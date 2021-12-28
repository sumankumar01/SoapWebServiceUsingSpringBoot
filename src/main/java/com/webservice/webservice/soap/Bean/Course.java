package com.webservice.webservice.soap.Bean;

import com.webservice.webservice.soap.service.CourseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;

public class Course {


    @Autowired
    CourseDetailsService service;

    private int id;
    private String name;
    private String Description;

    public Course(int id, String name, String description) {
        this.id = id;
        this.name = name;
        Description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return Description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
