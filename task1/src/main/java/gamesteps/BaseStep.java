package gamesteps;

import gameobjects.Unit;

public interface BaseStep {
    boolean doStep(Unit unit);
}
