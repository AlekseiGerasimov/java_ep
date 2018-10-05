package orientation;

import enums.Orientation;
import gameobjects.Unit;

public class EastOrientation extends BaseOrientation {
    @Override
    public void changeOrientation(Unit unit) {
        unit.setOrientation(Orientation.SOUTH);
    }
    @Override
    public void move(Unit unit){ unit.getPosition().setX(unit.getPosition().getX()+1); }
}
