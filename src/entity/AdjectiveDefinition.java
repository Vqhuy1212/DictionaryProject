package entity;

public class AdjectiveDefinition extends Definition {

    // Dạng so sánh của tính từ
    private String comparisonForm;

    /**
     * Constructor
     */
    public AdjectiveDefinition(String meaning,
                               String sentence,
                               String sentenceMeaning,
                               String comparisonForm) {

        super(meaning, sentence, sentenceMeaning);
        this.comparisonForm = comparisonForm;
    }

    @Override
    public String getType() {
        return "ADJECTIVE";
    }

    public String getComparisonForm() {
        return comparisonForm;
    }

    public void setComparisonForm(String comparisonForm) {
        this.comparisonForm = comparisonForm;
    }

    @Override
    public String toString() {
        return "[ADJECTIVE]\n" + super.toString();
    }
}