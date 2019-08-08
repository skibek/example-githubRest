package com.springrest.githubrest.model;


import java.util.Date;

public class RepoModel {

    private long id;
    private String fullName;
    private String description;
    private String cloneUrl;
    private int stars;
    private Date createdAt;

    public RepoModel(long id, String fullName, String description, String cloneUrl, int stars, Date createdAt) {
        this.id = id;
        this.fullName = fullName;
        this.description = description;
        this.cloneUrl = cloneUrl;
        this.stars = stars;
        this.createdAt = createdAt;
    }

    public static RepoModel convert(RepoGitHubModel repoGitHubModel) {
        RepoModel rm = new RepoModel(
                repoGitHubModel.getId(),
                repoGitHubModel.getFull_name(),
                repoGitHubModel.getDescription(),
                repoGitHubModel.getHtml_url(),
                repoGitHubModel.getStargazers_count(),
                repoGitHubModel.getCreated_at());
        return rm;
    }

    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDescription() {
        return description;
    }

    public String getCloneUrl() {
        return cloneUrl;
    }

    public int getStars() {
        return stars;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
