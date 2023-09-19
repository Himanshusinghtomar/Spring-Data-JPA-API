package com.example.springdatajpa.rest;

import com.example.springdatajpa.binding.Course;
import com.example.springdatajpa.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseRestController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/course")
    public ResponseEntity<String> createCourse(@RequestBody Course course)
    {

        String status = courseService.upsert(course);

        return new ResponseEntity<>(status, HttpStatus.CREATED);

    }

    @GetMapping("/course/{cid}")
    public ResponseEntity<Course> getCourse(@PathVariable Integer cid)
    {
        Course course = courseService.getById(cid);

        if(course == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<>(course,HttpStatus.OK);
        }
    }

    @DeleteMapping("/course/{cid}")
    public ResponseEntity<String> deleteCourse(@PathVariable Integer cid)
    {
        String status = courseService.deleteById(cid);

        return new ResponseEntity<>(status,HttpStatus.OK);
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses()
    {
        List<Course> courses = courseService.getAllCourses();

        if(courses.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else
        {
            return new ResponseEntity<>(courses,HttpStatus.OK);
        }
    }

    @PutMapping("/course")
    public ResponseEntity<String> updateCourse(@RequestBody Course course)
    {
        String status = courseService.upsert(course);

        return new ResponseEntity<>(status,HttpStatus.OK);
    }
}
