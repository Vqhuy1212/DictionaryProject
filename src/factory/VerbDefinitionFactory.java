package factory;

import entity.DictionaryEntry;
import entity.VerbDefinition;

import java.util.List;

public class VerbDefinitionFactory implements DefinitionFactory {

    @Override
    public DictionaryEntry create(List<String> params) {

        String meaning = getOrDefault(params, 0, "");
        String sentence = getOrDefault(params, 1, "");
        String sentenceMeaning = getOrDefault(params, 2, "");
        String verbForm = getOrDefault(params, 3, "");
        String tense = getOrDefault(params, 4, "");

        return new VerbDefinition(meaning, sentence, sentenceMeaning, verbForm, tense);
    }

    private String getOrDefault(List<String> params, int index, String defaultValue) {
        return (index < params.size() && params.get(index) != null)
                ? params.get(index)
                : defaultValue;
    }
}