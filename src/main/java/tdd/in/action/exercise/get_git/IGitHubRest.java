package tdd.in.action.exercise.get_git;

import tdd.in.action.exercise.get_git.model.Commit;

public interface IGitHubRest {
    String getCommits(final String url);
    Commit jsonToCommit(final String json);
}
