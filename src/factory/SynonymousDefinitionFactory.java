package factory;

import entity.DictionaryEntry;
import entity.SynonymousDefinition;

import java.util.ArrayList;
import java.util.List;

public class SynonymousDefinitionFactory implements DefinitionFactory {

    @Override
    public DictionaryEntry create(List<String> params) {
        // Với synonymous, toàn bộ params chính là danh sách từ đồng nghĩa
        return new SynonymousDefinition(new ArrayList<>(params));
    }
}