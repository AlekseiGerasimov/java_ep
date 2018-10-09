package menu;

public class MainMenu extends BaseMenu {

    private BaseMenu mainMenu;
    private BaseMenu operationMenu;

    public MainMenu(){
        mainMenu = new DataMenu();
        operationMenu = new OperationMenu();
    }

    @Override
    public void show() {
        generatorMenu("Сформировать показатели","Показать отчеты","Выход");
        String selectUser = selectMenu();
        checkInputValue(selectUser,"1","3");
        selector(selectUser);
    }

    public void selector(String select){
        switch (select){
            case "1" : mainMenu.show(); break;
            case "2" : operationMenu.show(); break;
            case "3" : System.exit(0);
            default:
                System.out.println("Ошибка");
        }
    }
}
