public class Threads {
    public static void main(String []args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread thread1 = new Thread(()->f());
        Thread thread2 = new Thread(()->f());
        thread1.start();
        Thread.sleep(1000);
        thread1.interrupt();
    }

    public static void f(){
        for(int i = 0; i < 20; ++i){
            try {
                Thread.currentThread().sleep(150);
                System.out.println(Thread.currentThread().getName() + " " + i);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
