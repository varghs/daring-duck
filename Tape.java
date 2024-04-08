import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Tape {
    ArrayList<Character> tape;
    int pos;

    public Tape(String input) {
        List<Character> list = IntStream.range(0, input.length())
                                    .mapToObj(i -> input.charAt(i))
                                    .toList();
        this.tape = new ArrayList<Character>(list);
        this.pos = 0;
    }

    public void left() {
        if (pos == 0) {
            this.tape.add(0, '/');
        } else {
            this.pos--;
        }
    }

    public void right() {
        if (this.pos == this.tape.size() - 1) {
            this.tape.add('/');
        }
        this.pos++;
    }

    public char read() {
        return this.tape.get(this.pos);
    }

    public void write(char c) {
        this.tape.set(this.pos, Character.valueOf(c));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.tape.size(); i++) {
            if (i == this.pos) {
                sb.append("[" + this.tape.get(i) + "]");
            } else {
                sb.append(this.tape.get(i));
            }
        }
        return sb.toString();
    }

    public int ones() {
        return (int) this.tape.stream().filter(c -> c == '1').count();
    }
}