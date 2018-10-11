package menu;

import helpers.Operation;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Pattern;

public abstract class BaseMenu {
    protected Operation operation = new Operation();

    public BaseMenu(){}

    public abstract void showMenu();

    protected boolean checkInputValue(String inputValue,String left,String right){
        if(Pattern.compile("[" + left + "-" + right + "]").matcher(inputValue).matches())
            return true;
        System.out.println("Некорректный диапазон значений. Введите значения в диапазоне от " + left + " до " + right);
        return false;
    }

    protected void generatorMenu(String... menu){
        int number = 1;
        for(String menuItem : menu){
            System.out.println(number++ + ". " + menuItem);
        }
    }

    protected String selectMenu(){
        System.out.println("Выберите значения (в случае множественного выбор вбить значения через пробел): ");
        return new Scanner(System.in).nextLine();
    }

    @Getter
    @Setter
    protected class TaskRunner extends TimerTask {
        protected BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        protected ExecutorService service = Executors.newCachedThreadPool();

        public TaskRunner(){ }

        public void setSelectMenu(String[] selectMenu) {
            for(String menuItem : selectMenu)
                queue.add(new Thread(()->operation.getMapOperation().get(menuItem).writeOnFile()));
        }

        @Override
        public void run() {
            Iterator iterator = queue.iterator();
            while(iterator.hasNext()){
                service.submit((Runnable)iterator.next());
            }
        }

    }
}
