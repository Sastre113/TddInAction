package tdd.in.action.exercise.get_git;

import lombok.Getter;
import tdd.in.action.exercise.get_git.model.Commit;

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

    }

    @Override
    public void imprimirCommit(Commit commit) {

    }
}