package commands;

import gameobjects.Unit;
import gamesteps.Step;

public class HorseStepCommand implements BaseCommand {
    @Override
    public void doCommand(Unit unit) {
        unit.doStep(Step.HorseStep);
    }
}
