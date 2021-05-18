package com.example.demo.repository;

import com.example.demo.model.ApiRequestCounter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiRequestCounterRepository extends JpaRepository<ApiRequestCounter, Long> {

    ApiRequestCounter findByLogin(String login);
}
