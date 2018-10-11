package factory;

import gameobjects.Tank;
import gameobjects.Unit;

public class TankFactory implements UnitFactory {
    @Override
    public Unit createUnit() {
        return new Tank();
    }
}
