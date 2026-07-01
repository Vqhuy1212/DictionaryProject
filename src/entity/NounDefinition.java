package entity;

public class NounDefinition extends Definition {

    /**
     * Constructor
     */
    public NounDefinition(String meaning,
                          String sentence,
                          String sentenceMeaning) {

        super(meaning, sentence, sentenceMeaning);
    }

    @Override
    public String getType() {
        return "NOUN";
    }

    @Override
    public String toString() {
        return "* " + getType() + "\n" + super.toString();
    }
}