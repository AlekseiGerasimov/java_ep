package menu;

public class OperationMenu extends BaseMenu{
    @Override
    public void show() {
        generatorMenu("Показать CPU","Показать HDD","Показать RAM","Выход в главное меню","Выход из программы");
        String menuItem = selectMenu();
        if(checkInputValue(menuItem,"1","4") == false)
            System.exit(-1);
        if(menuItem.equals("4")){
            new MainMenu().show();
            return;
        }
        if(menuItem.equals("5")){
            System.exit(0);
        }
        System.out.println("AVG: " + mapObject.get(menuItem).avgValue());
        System.out.println("MAX: " + mapObject.get(menuItem).maxValue());
        System.out.println("COUNT: " + mapObject.get(menuItem).count());
        show();
    }
}
