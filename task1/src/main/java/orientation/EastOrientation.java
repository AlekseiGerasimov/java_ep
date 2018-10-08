package orientation;

import gameobjects.Unit;

public class EastOrientation implements BaseOrientation {
    @Override
    public void changeOrientation(Unit unit) {
        unit.setOrientation(Orientation.SOUTH);
    }
    @Override
    public void move(Unit unit){ unit.getPosition().setX(unit.getPosition().getX()+1); }
}
