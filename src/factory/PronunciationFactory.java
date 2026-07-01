package factory;

import entity.DictionaryEntry;
import entity.Pronunciation;

import java.util.List;

public class PronunciationFactory implements DefinitionFactory {

    @Override
    public DictionaryEntry create(List<String> params) {

        String ipa = (!params.isEmpty()) ? params.get(0) : "";
        return new Pronunciation(ipa);
    }
}