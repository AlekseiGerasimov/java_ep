package Objects;

import Common.MyLogger;
import Interfaces.ILoadFile;

import java.io.*;
import java.util.logging.Level;

public class LoadFile implements ILoadFile{
    public LoadFile(){
    }

    @Override
    public void loadProjects(String fileName) {
        Project project = new Project();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader( new FileInputStream("Files/".concat(fileName)) , "CP1251"));
            while(reader.ready()){
                String []str = reader.readLine().split("-",2);
                project.addProject(str[0].trim(),str[1].trim());
            }
        } catch (FileNotFoundException e) {
            MyLogger.log(Level.WARNING,LoadFile.class.getName(),"loadProjects(String fileName)","Файл не найден, просьба проверить корректность пути до файла");
            System.exit(-1);
        } catch (IOException e) {
            MyLogger.log(Level.WARNING,LoadFile.class.getName(),"loadProjects(String fileName)","Прочитать файл невозможно. Проверить права доступа до файла и открытость файла в транзакционном режиме");
            System.exit(-1);
        }
    }

    @Override
    public void loadUsers(String fileName) {
        User user = new User();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader( new FileInputStream("Files/".concat(fileName)) , "CP1251"));
            while(reader.ready()){
                String str = reader.readLine();
                user.addUser(str.trim());
            }
        } catch (FileNotFoundException e) {
            MyLogger.log(Level.WARNING,LoadFile.class.getName(),"loadUsers(String fileName)","Файл не найден, просьба проверить корректность пути до файла");
            System.exit(-1);
        } catch (IOException e) {
            MyLogger.log(Level.WARNING,LoadFile.class.getName(),"loadUsers(String fileName)","Прочитать файл невозможно. Проверить права доступа до файла и открытость файла в транзакционном режиме");
            System.exit(-1);
        }
    }

    @Override
    public void loadIssue(String fileName) {
        Issue issue = new Issue();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader( new FileInputStream("Files/".concat(fileName)) , "CP1251"));
            while(reader.ready()){
                String[] str = reader.readLine().split("-",3);
                issue.addIssue(str[0].trim(),str[1].trim(),str[2].trim());
            }
        } catch (FileNotFoundException e) {
            MyLogger.log(Level.WARNING,LoadFile.class.getName(),"loadIssue(String fileName)","Файл не найден, просьба проверить корректность пути до файла");
            System.exit(-1);
        } catch (IOException e) {
            MyLogger.log(Level.WARNING,LoadFile.class.getName(),"loadIssue(String fileName)","Прочитать файл невозможно. Проверить права доступа до файла и открытость файла в транзакционном режиме");
            System.exit(-1);
        }
    }
}
