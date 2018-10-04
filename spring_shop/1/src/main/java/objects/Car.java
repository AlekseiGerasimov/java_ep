package objects;

public class Car {
    private int id;
    private String model;
    private String color;
    private String modelType;
    private int cost;

    public Car() {
    }

    public Car(String model, String color, String modelType, int cost) {
        this.model = model;
        this.color = color;
        this.modelType = modelType;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
