package orientation;

import baseobjects.Field;
import baseobjects.Orientation;
import baseobjects.Position;
import objects.Unit;

public class NorthOrientation extends BaseOrientation {
    @Override
    public void changeOrientation(Unit unit) {
        unit.setOrientation(Orientation.EAST);
    }
    public void move(Unit unit){
        int y = unit.getPosition().getY();
        if(y >= Field.Y){
            //TODO
            System.out.println("Исключение");
        }
        Position position = unit.getPosition();
        position.setY(position.getY()+1);
    }
}
