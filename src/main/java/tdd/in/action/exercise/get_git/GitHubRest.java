package tdd.in.action.exercise.get_git;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import tdd.in.action.exercise.get_git.exception.GitHubException;
import tdd.in.action.exercise.get_git.model.GitHubResponseCommit;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

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
    public List<GitHubResponseCommit> jsonToCommit(String json) {
        if(json == null || json.isEmpty() || json.isBlank()) {
            throw new GitHubException("Error GitHubRest::jsonToCommit. El json no debe de estar vacío");
        }

        Gson gson = new Gson();
        Type commitListType = new TypeToken<List<GitHubResponseCommit>>() {}.getType();
        return gson.fromJson(json, commitListType);
    }

}
