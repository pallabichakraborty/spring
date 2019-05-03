package com.restservice.example.springbootrestexample.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restservice.example.springbootrestexample.user.post.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
