package orientation;

// TODO: 10.10.2018 Именно сюда стоило бы применить паттерн State был бы интерфейс doStep(Position, StepType) и каждый enum сам бы знал куда делать Step
// TODO: 10.10.2018 Точно не уверен но скорее всего StepType внутри использовался бы как стратегия, для шага Horse или Simple \
public enum Orientation {
    NORTH,WEST,SOUTH,EAST
}
