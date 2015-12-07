
public class RealRandomizer implements Randomizer {

    public Move getRandomMove() {
        Move[] options = Move.values();
        //TODO: Move Math.random() calculation into a new class. Don't use test double for the whole randomiser class.
        //int index = rand.nextInt(options.length);
        int index = (int) (Math.random() * options.length);
        return options[index];
    }
}
