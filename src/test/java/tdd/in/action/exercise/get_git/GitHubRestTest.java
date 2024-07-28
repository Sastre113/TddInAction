package tdd.in.action.exercise.get_git;

import lombok.SneakyThrows;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import tdd.in.action.exercise.get_git.exception.GitHubException;
import tdd.in.action.exercise.get_git.model.GitHubResponseCommit;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GitHubRestTest {

    private static GitHubRest gitHubRest;

    @BeforeAll
    public static void setUp() {
        gitHubRest = new GitHubRest();
    }


    @Test
    void givenEmptyUrl_WhenGetCommits_ThenThrowException() {
        // Arrange
        String url = "";
        // Act - Assert
        Assertions.assertThrows(GitHubException.class, () -> gitHubRest.getCommits(url));
    }

    @Test
    void givenInvalidUrl_WhenGetCommits_ThenThrowException() {
        // Arrange
        String url = "https://fake.github.com";
        // Act - Assert
        Assertions.assertThrows(GitHubException.class, () -> gitHubRest.getCommits(url));
    }

    @Test
    void givenValidUrl_WhenGetCommits_ThenReturnSomething() {
        // Arrange
        String url = "https://api.github.com/repos/Sastre113/TddInAction/commits";
        // Act
        String response = gitHubRest.getCommits(url);
        // Assert
        Assertions.assertNotNull(response);
        Assertions.assertTrue(response.length() > 0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"   "})
    @NullAndEmptySource
    void givenStringNullOrEmpty_WhenJsonToCommit_ThenThrowException(String json) {
        Assertions.assertThrowsExactly(GitHubException.class, () -> gitHubRest.jsonToCommit(json));
    }

    @SneakyThrows
    @Test
    void givenValidJson_WhenJsonToCommit_ThenReturnNotNull() {
        // Arrange
        String json = new String(Files.readAllBytes(Paths.get("src/test/resources/json/commits.json")));

        // Act
        List<GitHubResponseCommit> response = gitHubRest.jsonToCommit(json);

        // Assert
        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.isEmpty());
    }

    @SneakyThrows
    @Test
    void givenValidJson_WhenJsonToCommit_ThenReturnListWithCommits() {
        // Arrange
        String sha = "f822ab283d129a20de1bc7f7c72256e2b61cf4d6";
        String node_id = "C_kwDOMWsIHNoAKGY4MjJhYjI4M2QxMjlhMjBkZTFiYzdmN2M3MjI1NmUyYjYxY2Y0ZDY";
        String htmlUrl = "https://github.com/Sastre113/TddInAction/commit/f822ab283d129a20de1bc7f7c72256e2b61cf4d6";
        String authorName = "Miguel Á. Sastre";
        String email = "sastre113@gmail.com";
        String date = "2024-07-23T16:15:01Z";
        String message = "Esqueleto para los test";

        String json = new String(Files.readAllBytes(Paths.get("src/test/resources/json/commitTest.json")));

        // Act
        List<GitHubResponseCommit> response = gitHubRest.jsonToCommit(json);
        GitHubResponseCommit firstCommit = response.get(0);

        // Assert
        Assertions.assertEquals(sha, firstCommit.getSha());
        Assertions.assertEquals(node_id, firstCommit.getNode_id());
        Assertions.assertEquals(htmlUrl, firstCommit.getHtml_url());
        Assertions.assertEquals(authorName, firstCommit.getCommit().getAuthor().getName());
        Assertions.assertEquals(email, firstCommit.getCommit().getAuthor().getEmail());
        Assertions.assertEquals(date, firstCommit.getCommit().getAuthor().getDate());
        Assertions.assertEquals(message, firstCommit.getCommit().getMessage());
    }
}