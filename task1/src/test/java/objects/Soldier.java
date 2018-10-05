package objects;

import baseobjects.Field;

public class Soldier extends Unit {
    private int numberRounds;
    public Soldier(){
        super();
        numberRounds = 30;
    }
    public void shoot(){
        if(numberRounds == 0){
            System.out.println("У вас кончились патроны");
            return;
        }
        numberRounds--;
        System.out.println("Выстрелил солдат");
    }

    @Override
    public void action(String command) {
        switch(command){
            case "F" : Field.setFillCell(this); break;
            case "T" : turnClockwise(); break;
            case "S" : shoot(); break;
            case "H" : Field.horseStep(this);
            default:
                System.out.println("Ошибка");
        }
    }
}
