public class Transition {
    char symbol;
    String destination;
    char write;
    Direction direction;

    public Transition(char symbol, String destination, char write, Direction direction) {
        this.symbol = symbol;
        this.destination = destination;
        this.write = write;
        this.direction = direction;
    }
}

enum Direction {
    LEFT,
    RIGHT
}