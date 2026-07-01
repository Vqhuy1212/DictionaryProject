package entity;

public class SynonymousDefinition extends Definition {

    /**
     * Constructor
     */
    public SynonymousDefinition(String synonyms) {

        super(synonyms, "", "");
    }

    @Override
    public String getType() {
        return "SYNONYMOUS";
    }

    @Override
    public String toString() {
        return "* " + getType() + "\n- " + meaning;
    }
}