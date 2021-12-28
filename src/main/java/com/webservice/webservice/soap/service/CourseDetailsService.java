package com.webservice.webservice.soap.service;


import com.in28minutes.courses.Status;
import com.webservice.webservice.soap.Bean.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class CourseDetailsService {

    private static List<Course> courses=new ArrayList<>();

    static
    {
        Course course1=new Course(1,"Spring","basic");
        courses.add(course1);

        Course course2=new Course(2,"Spring advance","Advance");
        courses.add(course2);

        Course course3=new Course(3,"Java","basic");
        courses.add(course3);


        Course course4=new Course(4,"Java advance","java advance learning");
        courses.add(course3);

    }

    ///course -Course findBy(int id)

    //deleteing course

    //updating courses

    //courses
    //LIstOfCourses

    public Course findById(int id)
    {
        for(Course course:courses)
        {
            if(course.getId()==id)
            {
                return course;
            }

        }
        return null;
    }
    public List<Course> findAll()
    {
        return courses;
    }
    public Status deleteById(int id) {
        Iterator<Course> iterator = courses.iterator();
        while (iterator.hasNext()) {
            Course course = iterator.next();
            if (course.getId() == id) {
                iterator.remove();
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }

}
