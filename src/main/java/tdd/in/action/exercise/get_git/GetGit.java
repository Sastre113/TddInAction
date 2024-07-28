package tdd.in.action.exercise.get_git;

import com.google.gson.Gson;
import lombok.Getter;
import tdd.in.action.exercise.get_git.model.GitHubResponseCommit;

import java.util.ArrayList;
import java.util.List;

/*
 * Source --> https://retosdeprogramacion.com/ejercicios
 * Crea un programa que lea los últimos 10 commits de este repositorio y muestre:
 * - Hash
 * - Autor
 * - Mensaje
 * - Fecha y hora
 *
 */
@Getter
public class GetGit implements IGetGit{

    private String owner;
    private String repository;
    private String url;
    private GitHubRest gitHubRest;

    public GetGit() {
        this("Sastre113", "TddInAction");
    }

    public GetGit(String owner, String repository) {
        this.owner = owner;
        this.repository = repository;
        this.url = String.format("https://api.github.com/repos/%s/%s/commits", owner, repository);
        this.gitHubRest = new GitHubRest();
    }

    @Override
    public void runGetCommits() {
        String commitsString = gitHubRest.getCommits(this.url);
        Gson gson = new Gson();
        List<Object> test = gson.fromJson(commitsString, ArrayList.class);

        System.out.println(test.get(0));
    }

    @Override
    public void imprimirCommit(GitHubResponseCommit commit) {

    }
}