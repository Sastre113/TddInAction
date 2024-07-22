package tdd.in.action.exercise.get_git;

import lombok.Getter;

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
public class GetGit {

    private String owner;
    private String repository;
    private String url;

    public GetGit() {
        this("Sastre113", "TddInAction");
    }

    public GetGit(String owner, String repository) {
        this.owner = owner;
        this.repository = repository;
        this.url = String.format("https://api.github.com/repos/%s/%s/commits", owner, repository);
    }



}
