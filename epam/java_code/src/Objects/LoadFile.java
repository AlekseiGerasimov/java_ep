package Objects;

import Interfaces.IIssues;
import Interfaces.ILoadFile;
import JDBC.ConnectionDB;

import java.io.*;
import java.sql.*;
import java.util.*;

public class LoadFile implements ILoadFile{

    @Override
    public void loadProjects(String fileName) {
        Map<String,String> fileProjects = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader( new FileInputStream("Files/".concat(fileName)) , "CP1251"));
            while(reader.ready()){
                String []str = reader.readLine().split("-",2);
                fileProjects.put(str[0],str[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Project project = new Project();
        for(Map.Entry<String,String> entry : fileProjects.entrySet()){
            project.addProject(entry.getKey(),entry.getValue());
        }
    }

    @Override
    public void loadUsers(String fileName) {
        List<String> fileProjects = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader( new FileInputStream("Files/".concat(fileName)) , "CP1251"));
            while(reader.ready()){
                String str = reader.readLine();
                fileProjects.add(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        User user = new User();
        for(String str : fileProjects){
            user.addUser(str);
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
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
