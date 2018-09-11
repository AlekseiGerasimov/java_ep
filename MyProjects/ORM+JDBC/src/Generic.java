public class Generic{
    public static void main(String []args){
        Test1<C> a = new Test1<>();
    }
}


class Test1<T extends A>{
    public Test1(){
    }
//    public void f(T t,<? extends A> a){
//        t.f();
//    }
}



abstract class A{
    public abstract void f();
}

class B extends A{
    public void f(){
        System.out.println("B");
    }
}

class C extends A{
    public void f(){
        System.out.println("C");
    }
}