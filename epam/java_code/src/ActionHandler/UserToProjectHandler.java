package ActionHandler;

import Interfaces.ActionsForHandlers;
import Objects.UserToProject;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Класс обрабатывает действия пользователя по работе с меню "Прикрепить пользователя к проекту"
 */
public class UserToProjectHandler implements ActionsForHandlers {
    public UserToProjectHandler(){
    }
    public void action(){
        int input_value;
        Scanner scanner = new Scanner(System.in);;
        UserToProject userToProject = new UserToProject();
        do {
            input_value = listActions();
            switch (input_value){
                case 1 :
                    userToProject.listUsers();
                    break;
                case 2 : {
                    System.out.println("Введите имя пользователя");
                    String nameUser = scanner.nextLine();
                    System.out.println("Введите название проекта");
                    String nameProject = scanner.nextLine();
                    userToProject.addUserToProject(nameUser, nameProject);
                }
                    break;
                case 3 : {
                    System.out.println("Введите имя пользователя");
                    String nameUser = scanner.nextLine();
                    System.out.println("Введите название проекта");
                    String nameProject = scanner.nextLine();
                    userToProject.removeUserFromProject(nameUser, nameProject);
                    break;
                }
                default: input_value = 4;
            }
        }while (input_value != 4);
        new MainConsoleWindow().action();
    }
    public int listActions(){
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("1. Все пользователи по всем проектам");
        System.out.println("2. Добавить пользователя к проекту");
        System.out.println("3. Удалить пользователя из проекта");
        System.out.println("4. Выход");
        System.out.println("------------------------------------------------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        String input_value;
        while(true){
            input_value = scanner.nextLine();
            if(Pattern.compile("[1-4]").matcher(input_value).matches()){
                break;
            }
            else{
                System.out.print("Введите корректное значение (от 1 до 4): ");
            }
        }
        return Integer.parseInt(input_value);
    }
}
