package com.springrest.githubrest.model;


import java.util.Date;

public class RepoGitHubModel {

    private long id;
    private String full_name;
    private String description;
    private String html_url;
    private int stargazers_count;
    private Date created_at;

    public RepoGitHubModel() {
    }

    public long getId() {
        return id;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getDescription() {
        return description;
    }

    public String getHtml_url() {
        return html_url;
    }

    public int getStargazers_count() {
        return stargazers_count;
    }

    public Date getCreated_at() {
        return created_at;
    }

    @Override
    public String toString() {
        return "RepoGitHubModel{" +
                "id=" + id +
                ", full_name='" + full_name + '\'' +
                ", description='" + description + '\'' +
                ", html_url='" + html_url + '\'' +
                ", stargazers_count=" + stargazers_count +
                ", created_at=" + created_at +
                '}';
    }
}
