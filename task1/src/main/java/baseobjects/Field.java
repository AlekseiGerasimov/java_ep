package baseobjects;

public abstract class Field {
    public static int X = 5;
    public static int Y = 5;

    private static boolean field[][] = new boolean[Field.X][Field.Y];

    public static boolean[][] getField(){
        return field;
    }

    public static void setField(int x, int y) {
        X = x;
        Y = y;
        Field.field = new boolean[x][y];
    }
}
