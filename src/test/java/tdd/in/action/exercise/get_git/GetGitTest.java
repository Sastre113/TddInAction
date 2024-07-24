package tdd.in.action.exercise.get_git;

import org.junit.jupiter.api.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GetGitTest {

    private static GetGit getGit;

    @BeforeAll
    public static void setUp() {
        getGit = new GetGit();
    }

    @Test
    public void defaultConstructor(){
        GetGit testGetGit = new GetGit();

        Assertions.assertEquals("Sastre113", testGetGit.getOwner());
        Assertions.assertEquals("TddInAction", testGetGit.getRepository());
        Assertions.assertEquals("https://api.github.com/repos/Sastre113/TddInAction/commits", testGetGit.getUrl());
    }

    @Test
    public void constructorWithParameters(){
        // Arrange
        String owner = "Pepe";
        String repository = "RepositorioDePrueba";
        String url = "https://api.github.com/repos/Pepe/RepositorioDePrueba/commits";

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
    void runGetCommits() {
        getGit.runGetCommits();
        Assertions.assertEquals(1, 0);
    }

    @Test
    void imprimirCommit() {
        Assertions.assertEquals(1, 0);
    }
}