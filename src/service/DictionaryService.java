package service;

import entity.Word;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DictionaryService implements DictionaryOperation {

    // Singleton instance
    private static DictionaryService instance;

    // Lưu để tra cứu nhanh
    private Map<String, Word> dictionary;

    // Lưu danh sách từ
    private LinkedList<Word> words;

    /**
     * Constructor private để đảm bảo Singleton
     */
    private DictionaryService() {
        dictionary = new HashMap<>();
        words = new LinkedList<>();
    }

    /**
     * Lấy instance duy nhất
     */
    public static DictionaryService getInstance() {

        if (instance == null) {
            instance = new DictionaryService();
        }

        return instance;
    }

    @Override
    public Word lookup(String keyword) {
        if (keyword == null) {
            return null;
        }

        return dictionary.get(keyword.toLowerCase());
    }

    @Override
    public void define(Word word) {

        if (word == null) {
            return;
        }

        String keyword = word.getKeyword().toLowerCase();

        // Nếu chưa có thì thêm mới
        if (!dictionary.containsKey(keyword)) {

            dictionary.put(keyword, word);
            words.add(word);

            return;
        }

        // Nếu đã tồn tại thì cập nhật
        Word existingWord = dictionary.get(keyword);

        existingWord.getDefinitions().addAll(word.getDefinitions());

        existingWord.getPronunciations().addAll(word.getPronunciations());

    }

    @Override
    public void drop(String keyword) {
        if (keyword == null) {
            return;
        }

        keyword = keyword.toLowerCase();

        Word removedWord = dictionary.remove(keyword);

        if (removedWord != null) {
            words.remove(removedWord);
        }
    }

    @Override
    public void export(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            for (Word word : words) {

                writer.write(word.toString());
                writer.newLine();
                writer.write("------------------------------------");
                writer.newLine();

            }

            System.out.println("Export successfully!");

        } catch (IOException e) {

            System.out.println("Export failed!");

        }
    }
}