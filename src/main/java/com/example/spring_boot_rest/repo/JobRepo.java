package com.example.spring_boot_rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_boot_rest.model.JobPost;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

}