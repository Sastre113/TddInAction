package tdd.in.action.exercise.get_git.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Author {
    private String name;
    private String email;
    private String date;
}
