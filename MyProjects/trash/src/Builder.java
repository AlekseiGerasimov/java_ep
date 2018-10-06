public class Builder {
    public static void main(String []args) {
        Director director = new Director(new WinBuilder());
        Computer computer = director.build();
        computer.info();
    }
}


class Computer{
    private String motherboard;
    private String videocard;
    private int CPU;
    private int capacity;
    private String name;
    public Computer(String motherboard, String videocard, int CPU, int capacity, String name) {
        this.motherboard = motherboard;
        this.videocard = videocard;
        this.CPU = CPU;
        this.capacity = capacity;
        this.name = name;
    }
    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }
    public void setVideocard(String videocard) {
        this.videocard = videocard;
    }
    public void setCPU(int CPU) {
        this.CPU = CPU;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setName(String name) {
        this.name = name;
    }
    void info(){
        System.out.println(motherboard + " "+videocard+" "+CPU+" "+capacity+ " "+name);
    }
}

abstract class ComputerBuilder{
    protected Computer computer;
    abstract Computer build();
}

class WinBuilder extends ComputerBuilder{
    public WinBuilder(){
        computer = new Computer("Win","Winvideocard",1000,10,"Windows");
    }
    @Override
    Computer build() {
        return computer;
    }
}

class Director{
    private ComputerBuilder builder;
    public Director(ComputerBuilder builder){
        this.builder = builder;
    }
    public Computer build(){
        return builder.build();
    }
    private int a;
}

