package ActionHandler;

import Objects.Project;


import java.util.Scanner;
import java.util.regex.Pattern;

public class ProjectHandler {
    public ProjectHandler(){
    }
    public void action(){
        int input_value;
        Scanner scanner;
        do {
            input_value = listProjectAction();
            switch (input_value){
                case 1 :
                    new Project().listProjects();
                    break;
                case 2 :
                    System.out.println("Введите название проекта и его описание");
                    scanner = new Scanner(System.in);
                    new Project().addProject(scanner.nextLine(),scanner.nextLine());
                    break;
                case 3 :
                    System.out.println("Введите название проекта");
                    scanner = new Scanner(System.in);
                    new Project().removeProject(scanner.nextLine());
                    break;
                case 4 :
                    System.out.println("Введите старое название проекта, далее введите новое название проект и его описание");
                    scanner = new Scanner(System.in);
                    new Project().updateProject(scanner.nextLine(),scanner.nextLine(),scanner.nextLine());
                    break;
                default: input_value = 5;
            }
        }while (input_value != 5);
        new MainConsoleWindow().action();
    }
    public int listProjectAction(){
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("1. Все проекты");
        System.out.println("2. Добавить проекта");
        System.out.println("3. Удалить проект");
        System.out.println("4. Обновить проект");
        System.out.println("5. Выход");
        System.out.println("------------------------------------------------------------------------------------------");
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
