package ActionHandler;

import Interfaces.ActionsForHandlers;
import Objects.Project;


import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Класс обрабатывает действия пользователя по работе с меню "Список проектов"
 */
public class ProjectHandler implements ActionsForHandlers {
    public ProjectHandler(){
    }
    public void action(){
        int input_value;
        Scanner scanner = new Scanner(System.in);
        Project project = new Project();
        do {
            input_value = listActions();
            switch (input_value){
                case 1 :
                    project.listProjects();
                    break;
                case 2 : {
                    System.out.println("Введите название проекта:");
                    String nameProject = scanner.nextLine().trim();
                    System.out.println("Введите описание проекта:");
                    String descriptionProject = scanner.nextLine().trim();
                    project.addProject(nameProject, descriptionProject);
                    break;
                }
                case 3 :
                    System.out.println("Введите название проекта, который необходимо удалить: ");
                    project.removeProject(scanner.nextLine().trim());
                    break;
                case 4 : {
                    System.out.println("Введите старое название проекта:");
                    String previousName = scanner.nextLine().trim();
                    System.out.println("Введите новое название проекта:");
                    String newName = scanner.nextLine().trim();
                    System.out.println("Введите описание нового проекта, если необходимо:");
                    String projectDescription = scanner.nextLine().trim();
                    project.updateProject(previousName, newName, projectDescription);
                    break;
                }
                default: input_value = 5;
            }
        }while (input_value != 5);
        new MainConsoleWindow().action();
    }

    public int listActions(){
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("1. Все проекты");
        System.out.println("2. Добавить проекта");
        System.out.println("3. Удалить проект");
        System.out.println("4. Обновить проект");
        System.out.println("5. Выход");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Выберите дальнейшее действие. Для этого введите цифру, соответствующую пункту меню: ");
        Scanner scanner = new Scanner(System.in);
        String input_value;
        while(true){
            input_value = scanner.nextLine();
            if(Pattern.compile("[1-5]").matcher(input_value).matches()){
                break;
            }
            else{
                System.out.print("Введите корректное значение (от 1 до 5): ");
            }
        }
        return Integer.parseInt(input_value);
    }
}
