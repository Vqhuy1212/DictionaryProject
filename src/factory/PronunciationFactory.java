package factory;

import entity.DictionaryEntry;
import entity.Pronunciation;

import java.util.List;

/**
 * Factory để tạo Pronunciation từ danh sách tham số
 */
public class PronunciationFactory implements DefinitionFactory {

    /**
     * Tạo Pronunciation từ params
     * @param params: [ipa]
     */
    @Override
    public DictionaryEntry create(List<String> params) {

        if (params == null || params.isEmpty()) {
            return null;
        }

        String ipa = params.get(0);

        if (ipa == null || ipa.trim().isEmpty()) {
            return null;
        }

        return new Pronunciation(ipa);
    }
}