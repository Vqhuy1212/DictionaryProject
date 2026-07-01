package factory;

import entity.DictionaryEntry;
import entity.Word;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Abstract Factory registry: nắm giữ toàn bộ concrete factory,
 * chọn factory phù hợp dựa vào "loại định nghĩa" bằng Map (không if/else).
 */
public class DictionaryFactory {

    private static final Map<String, DefinitionFactory> factories = new HashMap<>();

    static {
        factories.put("-p", new PronunciationFactory());
        factories.put("--pronoun", new PronunciationFactory());

        factories.put("-n", new NounDefinitionFactory());
        factories.put("--noun", new NounDefinitionFactory());

        factories.put("-a", new AdjectiveDefinitionFactory());
        factories.put("--adjective", new AdjectiveDefinitionFactory());

        factories.put("-v", new VerbDefinitionFactory());
        factories.put("--verb", new VerbDefinitionFactory());

        factories.put("-s", new SynonymousDefinitionFactory());
        factories.put("--synonymous", new SynonymousDefinitionFactory());
    }

    /**
     * Tạo Word mới (không cần factory riêng vì Word không có "loại" khác nhau)
     */
    public static Word createWord(String keyword) {
        return new Word(keyword);
    }

    /**
     * Tạo DictionaryEntry (Definition hoặc Pronunciation) dựa theo cờ loại (-n, -a, -v, -s, -p...)
     * @param typeFlag cờ loại định nghĩa, ví dụ "-n" hoặc "--noun"
     * @param params   tham số cần thiết để dựng entity
     * @return DictionaryEntry tương ứng, hoặc null nếu typeFlag không hợp lệ
     */
    public static DictionaryEntry createEntry(String typeFlag, List<String> params) {

        DefinitionFactory factory = factories.get(typeFlag);

        if (factory == null) {
            return null; // Controller/Service sẽ tự xử lý trường hợp typeFlag không hợp lệ
        }

        return factory.create(params);
    }

    /**
     * Kiểm tra một cờ loại có hợp lệ hay không - hữu ích cho Controller khi validate Request
     */
    public static boolean isValidTypeFlag(String typeFlag) {
        return factories.containsKey(typeFlag);
    }
}