
import java.util.concurrent.*;

public class Exception {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TMP tmp = new A1();
        Lol j = new C1(new C1(tmp));
        System.out.println(j.cost());
        System.out.println(j.getClass().getClassLoader());
    }
}



interface TMP{
    int cost();
}

class A1 implements TMP{
    @Override
    public int cost() {
        return 10;
    }
}

class B1 implements TMP{
    @Override
    public int cost() {
        return 100;
    }
}

abstract class Lol implements TMP{
    protected TMP tmp;
    public Lol(TMP tmp){
        this.tmp = tmp;
    }
    public abstract int cost();
}

class C1 extends Lol{
    public C1(TMP tmp){
        super(tmp);
    }
    public int cost() {
        return tmp.cost() + 1000;
    }
}

class D1 extends Lol{
    public D1(TMP tmp){
        super(tmp);
    }
    public int cost() {
        return tmp.cost() + 1;
    }
}