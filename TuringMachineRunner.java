/* Jason Chae, Shawn Varghese, Brendon Wan
 * 
 * Used https://www.geeksforgeeks.org/arrays-stream-method-in-java/ to understand how to use IntStream.range() and mapToObj() to convert a string to a list of characters, as well as other array processing features like filter().
*/

public class TuringMachineRunner {
    public static void main(String[] args) {
        TuringMachine tm = buildMachine(17);
        while (!tm.isFinal()) {
            char input = tm.tape.read();
            tm.processInput(input);
        }
        System.out.println(tm.tape.toString());
        System.out.println(tm.calculateScore());
    }

    static TuringMachine buildMachine(int n) {
        Transition[] s0Transitions = {
            new Transition('#', "s1", '#', Direction.RIGHT)
        };
        Transition[] s1Transitions = {
            new Transition('0', "s1", 'B', Direction.RIGHT),
            new Transition('1', "s2", 'A', Direction.RIGHT),
            new Transition('#', "sFinal", '#', Direction.RIGHT)
        };
        Transition[] s2Transitions = {
            new Transition('1', "s2", '1', Direction.RIGHT),
            new Transition('0', "s2", '0', Direction.RIGHT),
            new Transition('#', "s3", '#', Direction.RIGHT)
        };
        Transition[] s3Transitions = {
            new Transition('1', "s3", '1', Direction.RIGHT),
            new Transition('/', "s4", '1', Direction.LEFT)
        };
        Transition[] s4Transitions = {
            new Transition('1', "s4", '1', Direction.LEFT),
            new Transition('#', "s5", '#', Direction.LEFT)
        };
        Transition[] s5Transitions = {
            new Transition('0', "s5", '0', Direction.LEFT),
            new Transition('1', "s5", '1', Direction.LEFT),
            new Transition('A', "s5", '0', Direction.LEFT),
            new Transition('B', "s5", '1', Direction.LEFT),
            new Transition('#', "s1", '#', Direction.RIGHT)
        };
        Transition[] sFinalTransitions = {};

        State s0 = new State("s0", s0Transitions, false);
        State s1 = new State("s1", s1Transitions, false);
        State s2 = new State("s2", s2Transitions, false);
        State s3 = new State("s3", s3Transitions, false);
        State s4 = new State("s4", s4Transitions, false);
        State s5 = new State("s5", s5Transitions, false);
        State sFinal = new State("sFinal", sFinalTransitions, true);

        State[] states = {s0, s1, s2, s3, s4, s5, sFinal};
        Tape tape = new Tape("#" + "1".repeat(n) + "#");
        TuringMachine tm = new TuringMachine(states, s0, tape);

        return tm;
    }
}