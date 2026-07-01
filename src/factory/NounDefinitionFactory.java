package factory;

import entity.DictionaryEntry;
import entity.NounDefinition;

import java.util.List;

public class NounDefinitionFactory implements DefinitionFactory {

    @Override
    public DictionaryEntry create(List<String> params) {

        String meaning = getOrDefault(params, 0, "");
        String sentence = getOrDefault(params, 1, "");
        String sentenceMeaning = getOrDefault(params, 2, "");
        String pluralForm = getOrDefault(params, 3, "");

        return new NounDefinition(meaning, sentence, sentenceMeaning, pluralForm);
    }

    private String getOrDefault(List<String> params, int index, String defaultValue) {
        return (index < params.size() && params.get(index) != null)
                ? params.get(index)
                : defaultValue;
    }
}