package com.springrest.githubrest;

import com.springrest.githubrest.model.RepoGitHubModel;
import com.springrest.githubrest.service.DataStoreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestConsumerTest {

    private final Logger log = LoggerFactory.getLogger(RestConsumerTest.class);

    @Autowired
    DataStoreService dataStoreService;

    @Test
    public void test1() {
        RestTemplate restTemplate = dataStoreService.restTemplateWithProxy();
        RepoGitHubModel quote = restTemplate.getForObject("https://api.github.com/repos/skibek/Charts", RepoGitHubModel.class);
        log.info(quote.toString());
    }
}
