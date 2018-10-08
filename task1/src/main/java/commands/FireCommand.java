package commands;

import gameobjects.Tank;
import gameobjects.Unit;

//TODO Во всех классах комманд обработать исключение, при передаче в метод doCommand параметра некорректного типа
public class FireCommand implements BaseCommand {
    @Override
    public void doCommand(Unit unit) {
        ((Tank)unit).fire();
    }
}
