package DB.interfaces;

import Objects.Position;

public interface Iposition {
    void listPosition();
    void addPosition(Position worker);
    void removePosition(int id_position);
    void updatePosition(int id_position, String name_pos);

}
