public class TuringMachine {
    State[] states;
    State currentState;
    Tape tape;
    int inputSize;

    public TuringMachine(State[] states, State startState, Tape tape) {
        this.states = states;
        this.currentState = startState;
        this.tape = tape;
        this.inputSize = tape.tape.size();
    }

    public boolean isFinal() {
        return this.currentState.terminal;
    }

    State fromName(String name) {
        for (State s : this.states) {
            if (s.name.equals(name)) {
                return s;
            }
        }
        return null;
    }

    public void processInput(char input) {
        Transition t = currentState.transitionFromInput(input);
        this.currentState = fromName(t.destination);

        this.tape.write(t.write);
        if (t.direction == Direction.LEFT) {
            this.tape.left();
        } else {
            this.tape.right();
        }
    }

    public float calculateScore() {
        int ones = this.tape.ones();
        int S = this.states.length;
        int Γ = 6; // since we're not messing with the tape alphabet, we can hardcode this
        return (float) ones / (S + Γ + inputSize);
    }
}
