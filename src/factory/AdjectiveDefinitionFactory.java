package factory;

import entity.AdjectiveDefinition;
import entity.Definition;
import entity.DictionaryEntry;

import java.util.List;

/**
 * Factory để tạo AdjectiveDefinition từ danh sách tham số
 */
public class AdjectiveDefinitionFactory implements DefinitionFactory {

    /**
     * Tạo AdjectiveDefinition từ params
     * @param params: [meaning, sentence, sentenceMeaning]
     */
    @Override
    public DictionaryEntry create(List<String> params) {

        if (params == null || params.size() < 1) {
            return null;
        }

        String meaning = params.get(0);
        String sentence = params.size() > 1 ? params.get(1) : "";
        String sentenceMeaning = params.size() > 2 ? params.get(2) : "";

        if (meaning == null || meaning.trim().isEmpty()) {
            return null;
        }

        return new AdjectiveDefinition(meaning, sentence, sentenceMeaning);
    }
}