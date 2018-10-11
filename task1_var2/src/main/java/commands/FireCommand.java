package commands;

import gameobjects.Tank;
import gameobjects.Unit;

public class FireCommand implements BaseCommand {
    @Override
    public void doCommand(Unit unit) {
        ((Tank)unit).fire();
    }
}
