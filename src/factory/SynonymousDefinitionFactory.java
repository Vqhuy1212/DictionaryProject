package factory;

import entity.Definition;
import entity.DictionaryEntry;
import entity.SynonymousDefinition;

import java.util.List;

/**
 * Factory để tạo SynonymousDefinition từ danh sách tham số
 */
public class SynonymousDefinitionFactory implements DefinitionFactory {

    /**
     * Tạo SynonymousDefinition từ params
     * @param params: [synonyms] - chuỗi từ đồng nghĩa cách nhau bằng dấu phẩy
     */
    @Override
    public DictionaryEntry create(List<String> params) {

        if (params == null || params.isEmpty()) {
            return null;
        }

        // Lấy tất cả params và join lại (vì có thể có nhiều từ đồng nghĩa)
        StringBuilder synonymsBuilder = new StringBuilder();
        for (int i = 0; i < params.size(); i++) {
            if (i > 0) {
                synonymsBuilder.append(", ");
            }
            synonymsBuilder.append(params.get(i));
        }

        String synonyms = synonymsBuilder.toString();

        if (synonyms == null || synonyms.trim().isEmpty()) {
            return null;
        }

        return new SynonymousDefinition(synonyms);
    }
}