package Common;

import ActionHandler.*;
import Interfaces.ActionsForHandlers;
import JDBC.ConnectionDB;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Класс фабрика для создания обработчиков пунктов меню
 */
public class FactoryHandler {
    private static  ActionsForHandlers handler;
    private FactoryHandler(){
    }

    /**
     * Создания хендлера в зависимости от выбранного пункта меню
     * @return Возвращает хендлер
     */
    public static ActionsForHandlers getHandler(int value) {
        switch (value){
            case 1 :
                handler = new ProjectHandler();
                break;
            case 2 :
                handler = new UserHandler();
                break;
            case 3 :
                handler = new IssueHandler();
                break;
            case 4 :
                handler = new LoadFileHandler();
                break;
            case 5 :
                handler = new ReportHandler();
                break;
            case 6 :
                handler = new UserToProjectHandler();
                break;
            default:
                System.out.println("Произведен выход из системы");
                ConnectionDB.closeConnection();
                System.exit(0);
        }
        return handler;
    }
}
