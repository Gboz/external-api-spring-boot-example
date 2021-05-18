package com.example.demo.controller;

import com.example.demo.model.ApiRequestCounter;
import com.example.demo.service.GithubUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ApiRequestCounterController {

    private final GithubUserService githubUserService;

    @GetMapping
    public ApiRequestCounter getSingleApiRequestCounter(@PathVariable String login) {
        return githubUserService.getSingleGithubUser(login);
    }

    @PutMapping
    public ApiRequestCounter addApiRequestCounter(@RequestBody ApiRequestCounter apiRequestCounter) {
        return githubUserService.addApiRequestCounter(apiRequestCounter);
    }
}
