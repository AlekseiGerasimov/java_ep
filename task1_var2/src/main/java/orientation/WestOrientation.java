package orientation;

import gameobjects.Field;
import gameobjects.Position;
import gameobjects.Unit;

public class WestOrientation implements BaseOrientation {
    private Orientation orientation;
    public WestOrientation() {
        orientation = Orientation.WEST;
    }
    @Override
    public void changeOrientation(Unit unit) {
        unit.setOrientation(new NorthOrientation());
    }

    @Override
    public Position simpleStep(Field field, Unit unit){
        Position position = field.getUnitList().get(unit);
        return new Position(position.getX() - 1,position.getY());
    }

    @Override
    public Position horseStep(Field field, Unit unit){
        Position position = field.getUnitList().get(unit);
        return new Position(position.getX()-3,position.getY()+2);
    }
}
