package tdd.in.action.exercise.get_git;

import okhttp3.*;
import tdd.in.action.exercise.get_git.model.Commit;

import java.io.IOException;

public class GitHubRest implements IGitHubRest {

    public static final int HTTP_OK = 200;
    private OkHttpClient client;

    public GitHubRest() {
        this.client = new OkHttpClient();
    }

    @Override
    public String getCommits(String url) {
        if(url == null || url.length() == 0){
            throw new GitHubException("La url no puede estar vacía");
        }

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            if(response.code() != HTTP_OK) {
                throw new GitHubException("La url no es correcta");
            }


            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Commit jsonToCommit(String json) {
        return null;
    }

}
