package orientation;

import gameobjects.Unit;

public interface BaseOrientation {
    void changeOrientation(Unit unit);
    void move(Unit unit);
}
