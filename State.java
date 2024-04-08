public class State {
    String name;
    Transition[] transitions;
    boolean terminal;

    public State(String name, Transition[] transitions, boolean terminal) {
        this.name = name;
        this.transitions = transitions;
        this.terminal = terminal;
    }

    public Transition transitionFromInput(char input) {
        for (Transition t : transitions) {
            if (t.symbol == input) {
                return t;
            }
        }
        return null;
    }
}
