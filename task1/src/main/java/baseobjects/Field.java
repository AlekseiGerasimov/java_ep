package baseobjects;

public abstract class Field {
    public static final int X = 5;
    public static final int Y = 5;

    private static boolean field[][] = new boolean[Field.X][Field.Y];

    public static boolean[][] getField(){
        return field;
    }
}
