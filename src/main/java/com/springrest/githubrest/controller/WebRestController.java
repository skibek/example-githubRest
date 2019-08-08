package com.springrest.githubrest.controller;

import com.springrest.githubrest.model.RepoGitHubModel;
import com.springrest.githubrest.model.RepoModel;
import com.springrest.githubrest.model.TestModel;
import com.springrest.githubrest.service.DataStoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WebRestController {

    private final DataStoreService dataStoreService;

    public WebRestController(DataStoreService dataStoreService) {
        this.dataStoreService = dataStoreService;
    }

    private static final String template = "Hello, %s!";

    //@RequestMapping("/greeting")
    @GetMapping("/test/{owner}/{reponame}")
    public TestModel greeting(@PathVariable String owner, @PathVariable String reponame) {
        return new TestModel(1l, "tresc");
    }

    @GetMapping("/repositories/{owner}/{reponame}")
    public RepoGitHubModel repos(@PathVariable String owner, @PathVariable String reponame) {
        RestTemplate restTemplate = dataStoreService.restTemplateWithProxy();
        RepoGitHubModel quote = restTemplate.getForObject(
                "https://api.github.com/repos/" + owner + "/" + reponame,
                RepoGitHubModel.class);

        return quote;
    }

    @GetMapping("/repositoriesConvert/{owner}/{reponame}")
    public RepoModel reposWithConvert(@PathVariable String owner, @PathVariable String reponame) {
        RestTemplate restTemplate = dataStoreService.restTemplateWithProxy();
        RepoGitHubModel quote = restTemplate.getForObject(
                "https://api.github.com/repos/" + owner + "/" + reponame,
                RepoGitHubModel.class);

        return RepoModel.convert(quote);
    }

    @GetMapping("/test")
    public RepoModel test() {
        int id = (int) (Math.random() * dataStoreService.getMaxEntries() + 1);
        return dataStoreService.getRepoModelsCache().get(id);
    }
}
