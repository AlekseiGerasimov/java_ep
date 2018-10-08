package gameobjects;

import gamesteps.HorseStep;
import gamesteps.SimpleStep;

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
            case "F" :
                new SimpleStep().doStep(this);
                break;
            case "T" :
                turnClockwise();
                break;
            case "H" :
                new HorseStep().doStep(this);
                break;
            case "O" :
                fire();
                break;
            default:
                System.out.println("Ошибка");
        }
    }
}
