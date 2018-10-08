package gamesteps;

import baseobjects.Field;
import baseobjects.Position;
import gameobjects.Unit;

public class HorseStep implements BaseStep {
    @Override
    public boolean doStep(Unit unit) {
        boolean [][]field = Field.getField();
        int oldX = unit.getPosition().getX();
        int oldY = unit.getPosition().getY();
        unit.move();
        unit.move();
        unit.move();
        unit.turnClockwise();
        unit.move();
        unit.move();
        int newX = unit.getPosition().getX();
        int newY = unit.getPosition().getY();
        if(newX > Field.X || newY > Field.Y){
            System.out.println("Вы вышли за границы поля");
            return false;
        }
        else if(field[newX][newY] == true) {
            System.out.println("Поле занято " + newX + " " + newY + " , вы не можете произвести перемещение в данную точку карты");
            unit.setPosition(new Position(oldX,oldY));
            return false;
        }
        else{
            field[oldX][oldY] = false;
            field[newX][newY] = true;
            return true;
        }
    }
}
