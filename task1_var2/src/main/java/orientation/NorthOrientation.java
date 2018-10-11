package orientation;

import gameobjects.Field;
import gameobjects.Position;
import gameobjects.Unit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NorthOrientation implements BaseOrientation {
    private Orientation orientation;
    public NorthOrientation(){
        orientation = Orientation.NORTH;
    }
    @Override
    public void changeOrientation(Unit unit) {
        unit.setOrientation(new EastOrientation());
    }
    @Override
    public Position simpleStep(Field field, Unit unit){
        Position position = field.getUnitList().get(unit);
        return new Position(position.getX(),position.getY()+1);
    }
    @Override
    public Position horseStep(Field field, Unit unit){
        Position position = field.getUnitList().get(unit);
        return new Position(position.getX()+2,position.getY()+3);
    }
}
