package commands;

import gameobjects.Soldier;
import gameobjects.Unit;

public class ShootCommand implements BaseCommand {
    @Override
    public void doCommand(Unit unit) {
        ((Soldier)unit).shoot();
    }
}
