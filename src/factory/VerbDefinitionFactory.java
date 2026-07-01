package factory;

import entity.Definition;
import entity.DictionaryEntry;
import entity.VerbDefinition;

import java.util.List;

/**
 * Factory để tạo VerbDefinition từ danh sách tham số
 */
public class VerbDefinitionFactory implements DefinitionFactory {

    /**
     * Tạo VerbDefinition từ params
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

        return new VerbDefinition(meaning, sentence, sentenceMeaning);
    }
}