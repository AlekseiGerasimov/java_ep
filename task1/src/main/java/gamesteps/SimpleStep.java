package gamesteps;

import gameobjects.Field;
import gameobjects.Position;
import gameobjects.Unit;

public class SimpleStep implements BaseStep {
    @Override
    public void doStep(Unit unit) {
        boolean field[][] = Field.getField();
        int oldX = unit.getPosition().getX();
        int oldY = unit.getPosition().getY();
        unit.move();
        int newX = unit.getPosition().getX();
        int newY = unit.getPosition().getY();
        if(newX > Field.getX() || newY > Field.getY()){
            System.out.println("Вы вышли за границы поля");
        }
        else if(field[newX][newY] == true) {
            System.out.println("Поле занято " + newX + " " + newY + " , вы не можете произвести перемещение в данную точку карты");
            unit.setPosition(new Position(oldX,oldY));
        }
        else{
            field[oldX][oldY] = false;
            field[newX][newY] = true;
        }
    }
}
