package menu;

import java.util.*;


public class DataMenu extends BaseMenu {
    private Timer timer = new Timer();
    private TaskRunner taskRunner = new TaskRunner();
    private List<String> menu = new ArrayList<>();

    @Override
    public void showMenu() {
        show();
        runWriter(taskRunner);
        cancel();
        new MainMenu().showMenu();
    }

    public void show() {
        generatorMenu("Считать CPU","Считать HDD","Считать RAM","Выход в главное меню","Выход из программы");
        String []menu = selectMenu().split(" ");
        for(String menuItem : menu){
            if(checkInputValue(menuItem,"1","5") == false){
                System.out.println("Введен некорретный диапазон значений");
                System.exit(-1);
            }
            if(menuItem.equals("5")){
                System.exit(0);
            }
            if(menuItem.equals("4")){
                new MainMenu().showMenu();
                return;
            }
        }
        this.menu = Arrays.asList(menu);
        taskRunner.setSelectMenu(menu);
    }

    public void runWriter(TimerTask taskRunner){
        timer.schedule(taskRunner,0,getInterval());
    }

    public void cancel(){
        System.out.println("Нажмите клавишу ввода (Enter) для остановки записи в файл");
        new Scanner(System.in).nextLine();
        taskRunner.getService().shutdown();
        timer.cancel();
    }

    public long getInterval(){
        System.out.println("Введите интервал с которым необходимо считывать показатели в файл");
        return new Scanner(System.in).nextLong();
    }
}
