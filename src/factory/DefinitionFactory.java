package factory;

import entity.DictionaryEntry;

import java.util.List;

/**
 * Interface chung cho tất cả factory tạo DictionaryEntry (Definition/Pronunciation).
 * Đây là "Abstract Factory" - hợp đồng mà mọi factory cụ thể phải tuân theo.
 */
public interface DefinitionFactory {

    /**
     * Tạo một DictionaryEntry từ danh sách tham số thô lấy từ Request.
     * @param params tham số theo thứ tự: meaning, sentence, sentenceMeaning, ...(tùy loại)
     */
    DictionaryEntry create(List<String> params);
}