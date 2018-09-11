package DB;

import DB.Position.PositionDB;
import DB.Worker.WorkerDB;


public class ORM {
    public static void main(String []args){
        WorkerDB worker = new WorkerDB();
        worker.removePerson(0);
        worker.removePerson(-45);
        worker.removePerson(-44);
        worker.removePerson(-2);
        worker.removePerson(-1);
        worker.listPerson();
    }

}
