package commands;

import gameobjects.Unit;

public interface BaseCommand {
    void doCommand(Unit unit);
}
