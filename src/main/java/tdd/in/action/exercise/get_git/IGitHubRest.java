package tdd.in.action.exercise.get_git;

import tdd.in.action.exercise.get_git.model.GitHubResponseCommit;

import java.util.List;

public interface IGitHubRest {
    String getCommits(final String url);
    List<GitHubResponseCommit> jsonToCommit(final String json);
}
