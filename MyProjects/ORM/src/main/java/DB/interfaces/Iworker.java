package DB.interfaces;

import Objects.Worker;

public interface Iworker {
    void listPerson();
    void addPerson(Worker worker);
    void removePerson(int id_worker);
    void updatePerson(int id,String name,String male);
}
