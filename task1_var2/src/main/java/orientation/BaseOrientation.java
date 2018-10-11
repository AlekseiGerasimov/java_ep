package orientation;

import gameobjects.Field;
import gameobjects.Position;
import gameobjects.Unit;

public interface BaseOrientation {
    void changeOrientation(Unit unit);
    Position simpleStep(Field field, Unit unit);
    Position horseStep(Field field, Unit unit);
}
