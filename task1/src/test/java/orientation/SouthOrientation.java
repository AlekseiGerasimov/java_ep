package orientation;

import baseobjects.Orientation;
import baseobjects.Position;
import objects.Unit;

public class SouthOrientation extends BaseOrientation {
    @Override
    public void changeOrientation(Unit unit) {
        unit.setOrientation(Orientation.WEST);
    }

    public void move(Unit unit){
        int y = unit.getPosition().getY();
        if(y <= 0){
            //TODO
            System.out.println("Исключение");
        }
        Position position = unit.getPosition();
        position.setX(position.getY()-1);
    }
}
