package ActionHandler;

import Objects.LoadFile;
import Objects.Reports;

import java.util.Scanner;
import java.util.regex.Pattern;

public class LoadFileHandler {
    private LoadFile file;

    public LoadFileHandler(){
        file = new LoadFile();
    }
    public void action(){
        int input_value;
        Scanner scanner;
        do {
            input_value = listProjectAction();
            switch (input_value){
                case 1 :
                    System.out.println("Введите название файла с проектами");
                    scanner = new Scanner(System.in);
                    file.loadProjects(scanner.nextLine());
                    break;
                case 2 :
                    System.out.println("Введите название файла с пользователями");
                    scanner = new Scanner(System.in);
                    file.loadUsers(scanner.nextLine());
                    break;
                case 3 :
                    System.out.println("Введите название файла с дефектами");
                    scanner = new Scanner(System.in);
                    file.loadIssue(scanner.nextLine());
                    break;
                default: input_value = 4;
            }
        }while (input_value != 4);
        new MainConsoleWindow().action();
    }
    public int listProjectAction(){
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("1. Загрузить файл проектов");
        System.out.println("2. Загрузить файл пользователей");
        System.out.println("3. Загрузить файл дефектов");
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
