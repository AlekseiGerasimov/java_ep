package ActionHandler;

import ActionHandler.ProjectHandler;
import Objects.Issue;
import Objects.LoadFile;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MainConsoleWindow {
    public MainConsoleWindow(){

    }
    public int selectAction(){
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("1. Список проектов");
        System.out.println("2. Список пользователей");
        System.out.println("3. Список дефектов");
        System.out.println("4. Загрузка данных из файла в базу данных");
        System.out.println("5. Отчеты");
        System.out.println("6. Выход");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.print("Выберите дальнейшее действие. Для этого введите цифру, соответствующую пункту меню: ");
        Scanner scanner = new Scanner(System.in);
        String input_value;
        while(true){
            input_value = scanner.nextLine();
            if(Pattern.compile("[1-6]").matcher(input_value).matches()){
                break;
            }
            else{
                System.out.print("Введите корректное значение (от 1 до 6): ");
            }
        }
        return Integer.parseInt(input_value);
    }

    public void action(){
        int action = selectAction();
        switch (action){
            case 1 :
                ProjectHandler project = new ProjectHandler();
                project.action();
                break;
            case 2 :
                UserHandler user = new UserHandler();
                user.action();
                break;
            case 3 :
                IssueHandler issue = new IssueHandler();
                issue.action();
                break;
            case 4 :
                LoadFileHandler file = new LoadFileHandler();
                file.action();
                break;
            case 5 :
                ReportHandler report = new ReportHandler();
                report.action();
                break;
            default:
                System.out.println("Произведен выход из системы");
                System.exit(0);
        }
    }
}
