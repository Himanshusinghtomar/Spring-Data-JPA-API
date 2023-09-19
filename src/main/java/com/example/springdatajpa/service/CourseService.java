package com.example.springdatajpa.service;

import com.example.springdatajpa.binding.Course;

import java.util.List;

public interface CourseService {

    public String upsert(Course course);

    public Course getById(Integer cid);

    public List<Course> getAllCourses();

    public String deleteById(Integer cid);
}
