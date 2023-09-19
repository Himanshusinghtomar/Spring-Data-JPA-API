package com.example.springdatajpa.service;

import com.example.springdatajpa.binding.Course;
import com.example.springdatajpa.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepo;


    @Override
    public String upsert(Course course) {
        //Insert if primary key not available or Update if Primary key available

        courseRepo.save(course);

        return "Success";
    }

    @Override
    public Course getById(Integer cid) {

       Optional<Course> findById =  courseRepo.findById(cid);

       if(findById.isPresent())
       {
           return  findById.get();
       }
        return null;
    }

    @Override
    public List<Course> getAllCourses() {

        return courseRepo.findAll();
    }

    @Override
    public String deleteById(Integer cid) {

        if(courseRepo.existsById(cid))
        {
            courseRepo.deleteById(cid);
            return "Deleted Success";
        }
        else
        {
            return "No Record Found";
        }

    }
}
