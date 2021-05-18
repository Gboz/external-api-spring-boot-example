package com.example.demo.client.dto;

import lombok.Getter;

@Getter
public class GithubUserApiDto {

    private int id;
    private String login;
    private String name;
    private String type;
    private String avatar_url;
    private String created_at;
    private int followers;
    private int public_repos;
}
