package com.springrest.githubrest.service;

import com.github.javafaker.Faker;
import com.springrest.githubrest.model.RepoModel;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DataStoreService {

    List<RepoModel> repoModelsCache = new ArrayList<>();
    int maxEntries = 100;

    public DataStoreService() {
        generateRepos();
    }

    private void generateRepos() {
        if (repoModelsCache.size() == 0) {
            Faker faker = new Faker();

            for (long i = 0; i < maxEntries; i++) {
                RepoModel rm = new RepoModel(i,
                        faker.name().fullName(),
                        faker.gameOfThrones().quote(),
                        faker.internet().url(),
                        (int) Math.random() * 100,
                        new Date());
                repoModelsCache.add(rm);
            }
        }
    }

    public RestTemplate restTemplateWithProxy() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();

        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("v10nhq-mgt-wcg.bank.bps.corp", 8080));
        requestFactory.setProxy(proxy);

        return new RestTemplate(requestFactory);
    }

    public List<RepoModel> getRepoModelsCache() {
        return repoModelsCache;
    }

    public int getMaxEntries() {
        return maxEntries;
    }
}
