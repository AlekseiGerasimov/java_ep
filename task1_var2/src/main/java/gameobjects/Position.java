package gameobjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    private int x;
    private int y;

    @Override
    public String toString() {
        return "x = " + x + ", y = " + y;
    }
}
