import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThread {
    public static void main(String []args) throws InterruptedException {
        Thread thread1 = new Thread(()-> P.f());
        Thread thread2 = new Thread(()-> f());
        my_f(thread1,thread2);
        System.out.println(P.a);
    }

    public static void f(){
        for(int i = 0 ; i < 500; ++i){
            P.test1();
        }
    }

    public static void my_f(Thread thread1,Thread thread2){
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



class P{
    public static int a = 0;
    public synchronized static void f(){
        while(a < 100) {

        }
    }
    public static void test1(){
    }
}