package tdd.in.action.exercise.get_git;

import lombok.SneakyThrows;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import tdd.in.action.exercise.get_git.exception.GitHubException;
import tdd.in.action.exercise.get_git.model.Commit;

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
    void givenValidJson_WhenJsonToCommit_ThenReturnCommitObject() {
        // Arrange
        String json = new String(Files.readAllBytes(Paths.get("src/test/resources/json/commits.json")));

        // Act
        List<Commit> response = gitHubRest.jsonToCommit(json);

        // Assert
        Assertions.assertNotNull(response);
    }
}