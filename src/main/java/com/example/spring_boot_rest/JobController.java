package com.example.spring_boot_rest;

import com.example.spring_boot_rest.model.JobPost;
import com.example.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    // @ResponseBody oder instead of @Controller i can use @RestController
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }
}
