package tdd.in.action.exercise.get_git;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GitHubRestTest {

    private static GitHubRest gitHubRest;

    @BeforeAll
    public static void setUp(){
        gitHubRest = new GitHubRest();
    }


    @Test
    void givenEmptyUrl_WhenGetCommits_ThenThrowException() {
        // Arrange
        String url = "";
        // Act - Assert
        Assertions.assertThrows(GitHubException.class, () ->gitHubRest.getCommits(url));
    }

    @Test
    void givenInvalidUrl_WhenGetCommits_ThenThrowException() {
        // Arrange
        String url = "https://fake.github.com";
        // Act - Assert
        Assertions.assertThrows(GitHubException.class, () ->gitHubRest.getCommits(url));
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

    @Test
    void jsonToCommit() {
        Assertions.assertEquals(1, 0);
    }
}