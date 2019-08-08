package com.springrest.githubrest.controller;

import com.springrest.githubrest.RestConsumerTest;
import com.springrest.githubrest.model.RepoGitHubModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebRestControllerTest {

    private final Logger log = LoggerFactory.getLogger(RestConsumerTest.class);

    @Test
    public void test1() {
        //this wont work
        RestTemplate restTemplate = new RestTemplate();
        RepoGitHubModel quote = restTemplate.getForObject("http://localhost:8080/repositories/microsoft/terminal", RepoGitHubModel.class);
        log.info(quote.toString());
    }

}
