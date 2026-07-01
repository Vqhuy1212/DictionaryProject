package entity;

public class VerbDefinition extends Definition {

    /**
     * Constructor
     */
    public VerbDefinition(String meaning,
                          String sentence,
                          String sentenceMeaning) {

        super(meaning, sentence, sentenceMeaning);
    }

    @Override
    public String getType() {
        return "VERB";
    }

    @Override
    public String toString() {
        return "* " + getType() + "\n" + super.toString();
    }
}