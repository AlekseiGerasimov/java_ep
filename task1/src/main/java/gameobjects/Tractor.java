package gameobjects;

import baseobjects.HorseStep;
import baseobjects.SimpleStep;

public class Tractor extends Unit{
    public Tractor(){
        super();
    }
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
            default:
                System.out.println("Ошибка");
        }
    }
}
