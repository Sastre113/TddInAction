package tdd.in.action.exercise.get_git;

public class GitHubException extends RuntimeException {

    public GitHubException(String msg){
        super(msg);
    }

    public GitHubException(String msg, Throwable throwable){
        super(msg, throwable);
    }

}
