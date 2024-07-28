package tdd.in.action.exercise.get_git.exception;

public class GitHubException extends RuntimeException {

    public GitHubException(String msg){
        super(msg);
    }

    public GitHubException(String msg, Throwable throwable){
        super(msg, throwable);
    }

}
