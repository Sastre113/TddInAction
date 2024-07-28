package tdd.in.action.exercise.get_git.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Commit {
    private String sha;
}
