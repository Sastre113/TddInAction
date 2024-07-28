package tdd.in.action.exercise.get_git;

import tdd.in.action.exercise.get_git.model.GitHubResponseCommit;

public interface IGetGit {
    void runGetCommits();
    void imprimirCommit(GitHubResponseCommit commit);
}
