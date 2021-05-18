package com.example.demo.service;

import com.example.demo.client.GithubUserApi;
import com.example.demo.model.ApiRequestCounter;
import com.example.demo.model.GithubUserDto;
import com.example.demo.repository.ApiRequestCounterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GithubUserService {

    private final GithubUserApi githubUsersApi;
    private final ApiRequestCounterRepository apiRequestCounterRepository;

    public GithubUserDto getGithubUser(String login) {
        saveApiRequestCounter(login);
        return githubUsersApi.getGithubUser(login);
    }

    public ApiRequestCounter addApiRequestCounter(ApiRequestCounter apiRequestCounter) {
        return apiRequestCounterRepository.save(apiRequestCounter);
    }

    public ApiRequestCounter getSingleGithubUser(String login) {
        return apiRequestCounterRepository.findByLogin(login);
    }

    private void saveApiRequestCounter(String login) {
        ApiRequestCounter apiRequestCounter = new ApiRequestCounter();
        apiRequestCounter.setLogin(login);
        if (getSingleGithubUser(login) == null) {
            apiRequestCounter.setRequestCount(1);
        } else {
            apiRequestCounter.setRequestCount(getSingleGithubUser(login).getRequestCount() + 1);
        }
        addApiRequestCounter(apiRequestCounter);
    }
}
