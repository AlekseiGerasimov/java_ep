package ActionHandler;

import Interfaces.ActionsForHandlers;
import Objects.LoadFile;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Класс обрабатывает действия пользователя по загрузке данных из файла в базу данных
 * Класс работает с пунктом меню "Загрузка данных из файла в базу данных"
 */
public class LoadFileHandler implements ActionsForHandlers {
    private LoadFile file;

    public LoadFileHandler(){
        file = new LoadFile();
    }

    public void action(){
        int input_value;
        Scanner scanner;
        do {
            input_value = listActions();
            switch (input_value){
                case 1 :
                    System.out.println("Просьба обратить внимание, что файл должен располагаться в директории \"Files\".");
                    System.out.println("Введите название файла с проектами. Формат данных в файле должен соответствовать следующему виду: Проект - Описание проекта");
                    scanner = new Scanner(System.in);
                    file.loadProjects(scanner.nextLine());
                    break;
                case 2 :
                    System.out.println("Просьба обратить внимание, что файл должен располагаться в директории \"Files\".");
                    System.out.println("Введите название файла с пользователями. Формат данных в файле должен соответствовать следующему виду: Имя пользователя");
                    scanner = new Scanner(System.in);
                    file.loadUsers(scanner.nextLine());
                    break;
                case 3 :
                    System.out.println("Просьба обратить внимание, что файл должен располагаться в директории \"Files\".");
                    System.out.println("Введите название файла с дефектами. Формат данных в файле должен соответствовать следующему виду: Имя проекта - Имя пользователя - Описание дефекта");
                    scanner = new Scanner(System.in);
                    file.loadIssue(scanner.nextLine());
                    break;
                default: input_value = 4;
            }
        }while (input_value != 4);
        new MainConsoleWindow().action();
    }

    public int listActions(){
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
