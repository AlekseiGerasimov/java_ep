package gamesteps;

import gameobjects.Field;
import gameobjects.Unit;

public interface BaseStep {
    void doStep(Field field, Unit unit);
}
