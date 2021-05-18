package com.example.demo.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GithubUserDto {

    private int id;
    private String login;
    private String name;
    private String type;
    private String avatarUrl;
    private String createdAt;
    private float calculations;
}
