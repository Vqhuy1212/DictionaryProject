package entity;

import java.util.ArrayList;
import java.util.List;

public class SynonymousDefinition extends Definition {

    // Danh sách từ đồng nghĩa
    private List<String> synonyms;

    /**
     * Constructor
     */
    public SynonymousDefinition(List<String> synonyms) {

        super("", "", "");
        this.synonyms = synonyms;
    }

    @Override
    public String getType() {
        return "SYNONYMOUS";
    }

    public List<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    public void addSynonym(String synonym) {
        synonyms.add(synonym);
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append("[SYNONYMOUS]\n");

        for (String synonym : synonyms) {
            builder.append("- ").append(synonym).append("\n");
        }

        return builder.toString();
    }

}