package objects;

import baseobjects.Field;

public class Tank extends Unit {
    public Tank(){
        super();
    }
    public void fire(){
        System.out.println("Выстрелил танк");
    }

    @Override
    public void action(String command) {
        switch(command){
            case "F" : Field.setFillCell(this); break;
            case "T" : turnClockwise(); break;
            case "O" : fire(); break;
            case "H" : Field.horseStep(this);
            default:
                System.out.println("Ошибка");
        }
    }
}
