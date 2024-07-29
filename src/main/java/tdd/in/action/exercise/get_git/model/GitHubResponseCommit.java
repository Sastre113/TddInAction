package tdd.in.action.exercise.get_git.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GitHubResponseCommit {
    private String sha;
    private String node_id;
    private String html_url;
    private Commit commit;

    @Override
    public String toString() {
        return String.format("""
                SHA: %s
                Author: %s
                Email: %s
                Date: %s
                Commit_Message: %s
                URL: %s""", this.sha, this.commit.getAuthor().getName()
                , this.commit.getAuthor().getEmail(), this.commit.getAuthor().getDate()
                , this.commit.getMessage(), this.html_url);
    }
}
