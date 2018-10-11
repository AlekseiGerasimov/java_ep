package gamesteps;

import gameobjects.Field;
import gameobjects.Position;
import gameobjects.Unit;

public class HorseStep implements BaseStep {
    @Override
    public void doStep(Field field,Unit unit) {
        Position newPosition = unit.getOrientation().horseStep(field,unit);
        if(field.changeUnitPosition(newPosition)) {
            field.getUnitList().get(unit).setX(newPosition.getX());
            field.getUnitList().get(unit).setY(newPosition.getY());
        }
    }
}
