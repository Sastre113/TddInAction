package tdd.in.action.exercise.get_git;

import tdd.in.action.exercise.get_git.model.Commit;

import java.util.List;

public interface IGitHubRest {
    String getCommits(final String url);
    List<Commit> jsonToCommit(final String json);
}
