package factory;

import gameobjects.Soldier;
import gameobjects.Unit;

public class SoldierFactory implements UnitFactory {
    @Override
    public Unit createUnit() {
        return new Soldier();
    }
}
