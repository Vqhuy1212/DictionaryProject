package service;

import entity.Word;

public interface DictionaryOperation {

    /**
     * Tra cứu từ
     */
    Word lookup(String keyword);

    /**
     * Thêm hoặc cập nhật từ
     */
    void define(Word word);

    /**
     * Xóa từ
     */
    void drop(String keyword);

    /**
     * Xuất dữ liệu
     */
    void export(String filePath);

}