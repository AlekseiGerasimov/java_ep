package gameobjects;

import baseobjects.HorseStep;
import baseobjects.SimpleStep;

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
            case "F" :
                new SimpleStep().doStep(this);
                break;
            case "T" :
                turnClockwise();
                break;
            case "H" :
                new HorseStep().doStep(this);
                break;
            case "S" :
                shoot();
                break;
            default:
                System.out.println("Ошибка");
        }
    }
}
