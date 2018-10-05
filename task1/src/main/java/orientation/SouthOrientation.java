package orientation;

import enums.Orientation;
import gameobjects.Unit;

public class SouthOrientation extends BaseOrientation {
    @Override
    public void changeOrientation(Unit unit) {
        unit.setOrientation(Orientation.WEST);
    }
    @Override
    public void move(Unit unit){ unit.getPosition().setY(unit.getPosition().getY()-1); }
}
