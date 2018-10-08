package orientation;

import gameobjects.Unit;

public class WestOrientation implements BaseOrientation {
    @Override
    public void changeOrientation(Unit unit) {
        unit.setOrientation(Orientation.NORTH);
    }
    @Override
    public void move(Unit unit){ unit.getPosition().setX(unit.getPosition().getX()-1); }
}
