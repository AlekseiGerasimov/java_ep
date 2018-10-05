package orientation;

import baseobjects.Orientation;
import baseobjects.Position;
import objects.Unit;

public class WestOrientation extends BaseOrientation {
    @Override
    public void changeOrientation(Unit unit) {
        unit.setOrientation(Orientation.NORTH);
    }

    public void move(Unit unit){
        int x = unit.getPosition().getX();
        if(x <= 0){
            //TODO
            System.out.println("Исключение");
        }
        Position position = unit.getPosition();
        position.setX(position.getX()-1);
    }
}
