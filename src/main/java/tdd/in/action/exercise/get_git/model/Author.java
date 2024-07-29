package tdd.in.action.exercise.get_git.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    private String name;
    private String email;
    private String date;
}
