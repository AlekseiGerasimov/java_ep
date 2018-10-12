package menu;

public class MainMenu extends BaseMenu {

    public MainMenu(){
    }

    @Override
    public void showMenu() {
        generatorMenu("Сформировать показатели","Показать отчеты","Выход");
        String selectUser = selectMenu();
        if(checkInputValue(selectUser,"1","3") == false){
            System.exit(-1);
        }
        selector(selectUser);
    }

    public void selector(String select){
        switch (select){
            case "1" : new DataMenu().showMenu(); break;
            case "2" : new OperationMenu().showMenu(); break;
            case "3" : System.exit(0);
            default: System.out.println("Ошибка");
        }
    }
}
