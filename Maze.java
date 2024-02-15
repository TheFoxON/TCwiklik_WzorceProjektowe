// Interfejs budowniczego
interface MazeBuilder {
    void buildMaze();
    void buildRoom(int roomNumber);
    void buildDoor(int roomFrom, int roomTo);
    Maze getMaze();
}

// Implementacja budowniczego
class StandardMazeBuilder implements MazeBuilder {
    private Maze currentMaze;

    public StandardMazeBuilder() {
        this.currentMaze = new Maze();
    }

    public void buildMaze() {
        // Logika budowy labiryntu
    }

    public void buildRoom(int roomNumber) {
        // Logika budowy pokoju
    }

    public void buildDoor(int roomFrom, int roomTo) {
        // Logika budowy drzwi
    }

    public Maze getMaze() {
        return currentMaze;
    }
}

// Abstrakcyjna fabryka komponentów labiryntu
interface MazeFactory {
    Room makeRoom();
    Door makeDoor(Room room1, Room room2);
}

// Implementacja fabryki
class EnchantedMazeFactory implements MazeFactory {
    public Room makeRoom() {
        return new EnchantedRoom();
    }

    public Door makeDoor(Room room1, Room room2) {
        return new DoorNeedingSpell(room1, room2);
    }
}

// Metoda wytwórcza
abstract class MazeGame {
    protected abstract Maze makeMaze();
    protected abstract Room makeRoom();
    protected abstract Door makeDoor(Room room1, Room room2);

    public Maze createMaze() {
        Maze maze = makeMaze();
        Room room1 = makeRoom();
        Room room2 = makeRoom();
        Door door = makeDoor(room1, room2);

        maze.addRoom(room1);
        maze.addRoom(room2);
        
        room1.setSide(Direction.NORTH, makeWall());
        room1.setSide(Direction.EAST, door);
        room1.setSide(Direction.SOUTH, makeWall());
        room1.setSide(Direction.WEST, makeWall());

        room2.setSide(Direction.NORTH, makeWall());
        room2.setSide(Direction.EAST, makeWall());
        room2.setSide(Direction.SOUTH, makeWall());
        room2.setSide(Direction.WEST, door);

        return maze;
    }

    // Metoda wytwórcza dla ściany
    protected abstract Wall makeWall();
}

// Implementacja gry
class StandardMazeGame extends MazeGame {
    protected Maze makeMaze() {
        return new Maze();
    }

    protected Room makeRoom() {
        return new Room();
    }

    protected Door makeDoor(Room room1, Room room2) {
        return new Door(room1, room2);
    }

    protected Wall makeWall() {
        return new Wall();
    }
}

// Prototyp labiryntu
class MazePrototypeFactory implements Cloneable {
    private Maze prototypeMaze;
    private Room prototypeRoom;
    private Door prototypeDoor;

    public MazePrototypeFactory(Maze maze, Room room, Door door) {
        this.prototypeMaze = maze;
        this.prototypeRoom = room;
        this.prototypeDoor = door;
    }

    public Maze makeMaze() {
        try {
            return (Maze) prototypeMaze.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public Room makeRoom() {
        try {
            return (Room) prototypeRoom.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public Door makeDoor(Room room1, Room room2) {
        try {
            Door door = (Door) prototypeDoor.clone();
            door.initialize(room1, room2);
            return door;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

// Klasa labiryntu
class Maze implements Cloneable {
    public void addRoom(Room room) {
        // Logika dodawania pokoju do labiryntu
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // Implementacja klonowania labiryntu
        return super.clone();
    }
}

// Klasa pokoju
class Room implements Cloneable {
    // Implementacja pokoju
}

// Klasa drzwi
class Door implements Cloneable {
    // Implementacja drzwi

    public void initialize(Room room1, Room room2) {
        // Logika inicjalizacji drzwi
    }
}

// Klasa ściany
class Wall {
    // Implementacja ściany
}

// Klasa pokoju z czarem
class EnchantedRoom extends Room {
    // Implementacja pokoju z czarem
}

// Klasa drzwi z zaklęciem
class DoorNeedingSpell extends Door {
    // Implementacja drzwi z zaklęciem
}

// Kierunek
enum Direction {
    NORTH, SOUTH, EAST, WEST;
}
