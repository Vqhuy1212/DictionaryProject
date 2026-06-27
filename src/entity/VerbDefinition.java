package entity;

public class VerbDefinition extends Definition {

    // Dạng của động từ (Base, V-ing, V-ed, V3)
    private String verbForm;

    // Thì của động từ
    private String tense;

    /**
     * Constructor
     */
    public VerbDefinition(String meaning,
                          String sentence,
                          String sentenceMeaning,
                          String verbForm,
                          String tense) {

        super(meaning, sentence, sentenceMeaning);

        this.verbForm = verbForm;
        this.tense = tense;
    }

    @Override
    public String getType() {
        return "VERB";
    }

    public String getVerbForm() {
        return verbForm;
    }

    public void setVerbForm(String verbForm) {
        this.verbForm = verbForm;
    }

    public String getTense() {
        return tense;
    }

    public void setTense(String tense) {
        this.tense = tense;
    }

    @Override
    public String toString() {
        return "[VERB]\n" + super.toString();
    }
}