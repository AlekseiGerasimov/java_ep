package factory;

import gameobjects.Tractor;
import gameobjects.Unit;

public class TractorFactory implements UnitFactory {
    @Override
    public Unit createUnit() {
        return new Tractor();
    }
}
