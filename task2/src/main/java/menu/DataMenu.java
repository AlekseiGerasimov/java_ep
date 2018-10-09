package menu;

import helpers.TaskRunner;

import java.util.*;

public class DataMenu extends BaseMenu {
    private static List<String> menu;
    private Timer timer = new Timer();

    public void showMenu() {
        generatorMenu("Считать CPU","Считать HDD","Считать RAM","Выход в главное меню","Выход из программы");
        String []menu = selectMenu().split(" ",3);
        for(String menuItem : menu){
            if(checkInputValue(menuItem,"1","5") == false)
                System.exit(-1);
        }
        this.menu = Arrays.asList(menu);
    }

    public void cancel(){
        System.out.println("Введите любой знак для остановки записи");
        Scanner scanner =  new Scanner(System.in);
        String str = scanner.nextLine();
        timer.cancel();
    }

    public long getInteval(){
        System.out.println("Введите интервал с которым необходимо считывать показатели в файл");
        Scanner scanner = new Scanner(System.in);
        long interval = scanner.nextLong();
        return interval;
    }

    @Override
    public void show() {
        showMenu();
        if(menu.contains("5")){
            System.exit(0);
        }
        if(menu.contains("4")){
            new MainMenu().show();
            return;
        }
        runWriter(new TaskRunner());
        cancel();
        show();
    }

    public void runWriter(TimerTask taskRunner){
        timer.schedule(taskRunner,0,getInteval());
    }

    public static List<String> getMenu() {
        return menu;
    }
}
