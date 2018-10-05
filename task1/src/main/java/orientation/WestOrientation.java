package orientation;

import enums.Orientation;
import gameobjects.Unit;

public class WestOrientation extends BaseOrientation {
    @Override
    public void changeOrientation(Unit unit) {
        unit.setOrientation(Orientation.NORTH);
    }
    @Override
    public void move(Unit unit){ unit.getPosition().setX(unit.getPosition().getX()-1); }
}
