package commands;

import gameobjects.Unit;

public class TurnCommand implements BaseCommand {
    @Override
    public void doCommand(Unit unit) {
        unit.turnClockwise();
    }
}
