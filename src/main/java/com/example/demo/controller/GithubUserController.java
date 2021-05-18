package com.example.demo.controller;

import com.example.demo.model.ApiRequestCounter;
import com.example.demo.model.GithubUserDto;
import com.example.demo.service.GithubUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class GithubUserController {

    private final GithubUserService githubUserService;

    @GetMapping("/users/{login}")
    public GithubUserDto getGithubUser(@PathVariable String login) {
        return githubUserService.getGithubUser(login);
    }
}
