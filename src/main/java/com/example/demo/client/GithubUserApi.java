package com.example.demo.client;

import com.example.demo.client.dto.GithubUserApiDto;
import com.example.demo.model.ApiRequestCounter;
import com.example.demo.model.GithubUserDto;
import com.example.demo.service.GithubUserService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GithubUserApi {

    private final static String GITHUB_USERS_URL = "https://api.github.com/users/";
    private RestTemplate restTemplate = new RestTemplate();

    public GithubUserDto getGithubUser(String user) {
        GithubUserApiDto githubUserApiDto = restTemplate.getForObject(GITHUB_USERS_URL + user, GithubUserApiDto.class);
        return GithubUserDto.builder()
                .id(githubUserApiDto.getId())
                .login(githubUserApiDto.getLogin())
                .name(githubUserApiDto.getName())
                .type(githubUserApiDto.getType())
                .avatarUrl(githubUserApiDto.getAvatar_url())
                .createdAt(githubUserApiDto.getCreated_at())
                .calculations((float) (6.0 / githubUserApiDto.getFollowers() * (2.0 + githubUserApiDto.getPublic_repos())))
                .build();
    };

}
