package orientation;

import gameobjects.Field;
import gameobjects.Position;
import gameobjects.Unit;

public class SouthOrientation implements BaseOrientation {
    private Orientation orientation;
    public SouthOrientation() {
        orientation = Orientation.SOUTH;
    }
    @Override
    public void changeOrientation(Unit unit) {
        unit.setOrientation(new WestOrientation());
    }

    @Override
    public Position simpleStep(Field field, Unit unit){
        Position position = field.getUnitList().get(unit);
        return new Position(position.getX(),position.getY()-1);
    }

    @Override
    public Position horseStep(Field field, Unit unit){
        Position position = field.getUnitList().get(unit);
        return new Position(position.getX()-3,position.getY()-2);
    }
}
