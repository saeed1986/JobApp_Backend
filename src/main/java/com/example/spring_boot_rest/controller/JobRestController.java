package com.example.spring_boot_rest.controller;

import com.example.spring_boot_rest.model.JobPost;
import com.example.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // if it is Controller, it means that i want to return view name but in this case i don't want to return view name but data, there for i use RestController
@CrossOrigin(origins ="http://localhost:3000") // this annotation allows frontend to access the backend
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping(path="jobPosts", produces = {"application/json"})
    // @ResponseBody oder instead of @Controller i can use @RestController
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable int postId) {
        return service.getJob(postId);
    }

    @PostMapping(path="jobPost", consumes = {"application/xml"})
    public JobPost addJob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPosts){
        service.updateJob(jobPosts);
        return service.getJob(jobPosts.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId) {
        service.deleteJob(postId);
        return "deleted";
    }

}
