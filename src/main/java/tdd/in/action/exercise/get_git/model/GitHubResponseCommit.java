package tdd.in.action.exercise.get_git.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GitHubResponseCommit {
    private String sha;
    private String node_id;
    private String html_url;
    private Commit commit;
}
