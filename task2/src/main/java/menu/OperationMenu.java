package menu;

public class OperationMenu extends BaseMenu{
    @Override
    public void showMenu() {
        generatorMenu("Показать CPU","Показать HDD","Показать RAM","Выход в главное меню","Выход из программы");
        String menuItem = selectMenu();
        if(checkInputValue(menuItem,"1","5") == false)
            System.exit(-1);
        if(menuItem.equals("5")){
            System.exit(0);
        }
        if(menuItem.equals("4")){
            new MainMenu().showMenu();
            return;
        }
        System.out.println("------------------------------------------");
        System.out.println("AVG: " + operation.getMapOperation().get(menuItem).avgValue());
        System.out.println("MAX: " + operation.getMapOperation().get(menuItem).maxValue());
        System.out.println("COUNT: " + operation.getMapOperation().get(menuItem).count());
        System.out.println("------------------------------------------");
        showMenu();
    }
}
