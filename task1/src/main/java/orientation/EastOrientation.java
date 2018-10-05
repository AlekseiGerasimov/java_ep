package orientation;

import baseobjects.Field;
import baseobjects.Orientation;
import baseobjects.Position;
import objects.Unit;

public class EastOrientation extends BaseOrientation {
    @Override
    public void changeOrientation(Unit unit) {
        unit.setOrientation(Orientation.SOUTH);
    }

    public void move(Unit unit){
        int x = unit.getPosition().getX();
        if(x >= Field.Y){
            //TODO
            System.out.println("Исключение");
        }
        Position position = unit.getPosition();
        position.setX(position.getX()+1);
    }
}
