package factory;

import entity.AdjectiveDefinition;
import entity.DictionaryEntry;

import java.util.List;

public class AdjectiveDefinitionFactory implements DefinitionFactory {

    @Override
    public DictionaryEntry create(List<String> params) {

        String meaning = getOrDefault(params, 0, "");
        String sentence = getOrDefault(params, 1, "");
        String sentenceMeaning = getOrDefault(params, 2, "");
        String comparisonForm = getOrDefault(params, 3, "");

        return new AdjectiveDefinition(meaning, sentence, sentenceMeaning, comparisonForm);
    }

    private String getOrDefault(List<String> params, int index, String defaultValue) {
        return (index < params.size() && params.get(index) != null)
                ? params.get(index)
                : defaultValue;
    }
}