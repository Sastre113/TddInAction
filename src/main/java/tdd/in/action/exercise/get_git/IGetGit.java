package tdd.in.action.exercise.get_git;

import tdd.in.action.exercise.get_git.model.Commit;

public interface IGetGit {
    void runGetCommits();
    void imprimirCommit(Commit commit);
}
