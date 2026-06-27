package entity;

public class NounDefinition extends Definition {

    // Dạng số nhiều của danh từ
    private String pluralForm;

    /**
     * Constructor
     */
    public NounDefinition(String meaning,
                          String sentence,
                          String sentenceMeaning,
                          String pluralForm) {

        super(meaning, sentence, sentenceMeaning);
        this.pluralForm = pluralForm;
    }

    @Override
    public String getType() {
        return "NOUN";
    }

    public String getPluralForm() {
        return pluralForm;
    }

    public void setPluralForm(String pluralForm) {
        this.pluralForm = pluralForm;
    }

    @Override
    public String toString() {
        return "[NOUN]\n" + super.toString();
    }
}