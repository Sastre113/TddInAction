package tdd.in.action.exercise.get_git;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tdd.in.action.exercise.get_git.model.Author;
import tdd.in.action.exercise.get_git.model.Commit;
import tdd.in.action.exercise.get_git.model.GitHubResponseCommit;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GetGitTest {


    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Mock
    private GitHubRest gitHubRest;

    @InjectMocks
    private GetGit getGit;

    @BeforeEach
    public void setUp() {
        this.getGit = new GetGit();
        MockitoAnnotations.openMocks(this);
        System.setOut(new PrintStream(this.outputStreamCaptor));
    }

    @Test
    void defaultConstructor(){
        GetGit testGetGit = new GetGit();

        Assertions.assertEquals("Sastre113", testGetGit.getOwner());
        Assertions.assertEquals("TddInAction", testGetGit.getRepository());
        Assertions.assertEquals("https://api.github.com/repos/Sastre113/TddInAction/commits", testGetGit.getUrl());
    }

    @Test
    void constructorWithParameters(){
        // Arrange
        String owner = "Pepe";
        String repository = "RepositorioDePrueba";
        String url = "https://api.github.com/repos/Pepe/RepositorioDePrueba/commits";

        /*
            El uso de Mockito en este caso es innecesario.
            Simplemente, se ha usado con fines didácticos.
         */
        GetGit getGitMock = mock(GetGit.class);
        when(getGitMock.getOwner()).thenReturn(owner);
        when(getGitMock.getRepository()).thenReturn(repository);
        when(getGitMock.getUrl()).thenReturn(url);

        // Act
        GetGit testGetGit = new GetGit(owner, repository);

        // Assert
        Assertions.assertEquals(owner, testGetGit.getOwner());
        Assertions.assertEquals(repository, testGetGit.getRepository());
        Assertions.assertEquals(url, testGetGit.getUrl());
    }

    @Test
    void whenRunGetCommits_thenReturnSomething() {
        // Arrange
        GetGit getGit = new GetGit();
        // Act
        getGit.runGetCommits();
        String actualOutput = outputStreamCaptor.toString().trim();

        // Assert
        Assertions.assertTrue(actualOutput != null && !actualOutput.isBlank());
    }

    @Test
    void whenRunGetCommits_thenReturnOkResponse() {
        // Arrange
        String url = "https://api.github.com/repos/Sastre113/TddInAction/commits";
        String expectedStr = """
                --- COMMIT
                SHA: f822ab283d129a20de1bc7f7c72256e2b61cf4d6
                Author: Miguel Á. Sastre
                Email: sastre113@gmail.com
                Date: 2024-07-23T16:15:01Z
                Commit_Message: Esqueleto para los test
                URL: https://github.com/Sastre113/TddInAction/commit/f822ab283d129a20de1bc7f7c72256e2b61cf4d6
                --- END COMMIT""";

        String commitString = "[{\"sha\":\"f822ab283d129a20de1bc7f7c72256e2b61cf4d6\", \"commit\": {\"author\": {\"name\": \"Miguel Á. Sastre\", \"email\": \"sastre113@gmail.com\", \"date\": \"2024-07-23T16:15:01Z\"}, \"message\": \"Esqueleto para los test\"}, \"html_url\": \"https://github.com/Sastre113/TddInAction/commit/f822ab283d129a20de1bc7f7c72256e2b61cf4d6\"}]";
        Author mockAuthor = Author.builder()
                .name("Miguel Á. Sastre")
                .email("sastre113@gmail.com")
                .date("2024-07-23T16:15:01Z")
                .build();
        Commit mockCommit = Commit.builder()
                .author(mockAuthor)
                .message("Esqueleto para los test")
                .build();
        GitHubResponseCommit mockResponse = GitHubResponseCommit.builder()
                .sha("f822ab283d129a20de1bc7f7c72256e2b61cf4d6")
                .commit(mockCommit)
                .node_id("C_kwDOMWsIHNoAKGY4MjJhYjI4M2QxMjlhMjBkZTFiYzdmN2M3MjI1NmUyYjYxY2Y0ZDY")
                .html_url("https://github.com/Sastre113/TddInAction/commit/f822ab283d129a20de1bc7f7c72256e2b61cf4d6")
                .build();


        List<GitHubResponseCommit> mockCommitList = Collections.singletonList(mockResponse);
        when(this.gitHubRest.getCommits(url)).thenReturn(commitString);
        when(this.gitHubRest.jsonToCommit(commitString)).thenReturn(mockCommitList);

        // Act
        this.getGit.runGetCommits();
        String actualOutput = outputStreamCaptor.toString().trim();

        // Assert
        Assertions.assertEquals(expectedStr, actualOutput);
    }
}