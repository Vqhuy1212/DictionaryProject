package entity;

public class AdjectiveDefinition extends Definition {

    /**
     * Constructor
     */
    public AdjectiveDefinition(String meaning,
                               String sentence,
                               String sentenceMeaning) {

        super(meaning, sentence, sentenceMeaning);
    }

    @Override
    public String getType() {
        return "ADJECTIVE";
    }

    @Override
    public String toString() {
        return "* " + getType() + "\n" + super.toString();
    }
}