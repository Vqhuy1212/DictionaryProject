package service;

import entity.Word;
import entity.Definition;
import entity.Pronunciation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DictionaryService implements DictionaryOperation {

    // Singleton instance
    private static DictionaryService instance;

    // Lưu để tra cứu nhanh
    private Map<String, Word> dictionary;

    // Lưu danh sách từ
    private LinkedList<Word> words;

    // Đường dẫn thư mục lưu trữ .def files
    private static final String DICTIONARY_DIR = "dictionary_data";

    /**
     * Constructor private để đảm bảo Singleton
     */
    private DictionaryService() {
        dictionary = new HashMap<>();
        words = new LinkedList<>();

        // Tạo thư mục nếu chưa tồn tại
        File dir = new File(DICTIONARY_DIR);
        if (!dir.exists()) {
            dir.mkdir();
        }

        // Load tất cả từ từ file
        loadAllWords();
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

    /**
     * Load tất cả từ từ các file .def
     */
    private void loadAllWords() {
        File dir = new File(DICTIONARY_DIR);
        File[] files = dir.listFiles((d, name) -> name.endsWith(".def"));

        if (files != null) {
            for (File file : files) {
                loadWordFromFile(file);
            }
        }
    }

    /**
     * Load một từ từ file .def
     */
    private void loadWordFromFile(File file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Word word = (Word) ois.readObject();
            if (word != null) {
                dictionary.put(word.getKeyword().toLowerCase(), word);
                words.add(word);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading word from file: " + file.getName());
        }
    }

    /**
     * Lưu một từ vào file .def
     */
    private void saveWordToFile(Word word) {
        if (word == null) {
            return;
        }

        String fileName = DICTIONARY_DIR + File.separator + word.getKeyword().toLowerCase() + ".def";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(word);
            oos.flush();
        } catch (IOException e) {
            System.err.println("Error saving word to file: " + e.getMessage());
        }
    }

    /**
     * Xóa file .def của một từ
     */
    private void deleteWordFile(String keyword) {
        String fileName = DICTIONARY_DIR + File.separator + keyword.toLowerCase() + ".def";
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
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

        } else {
            // Nếu đã tồn tại thì cập nhật
            Word existingWord = dictionary.get(keyword);

            existingWord.getDefinitions().addAll(word.getDefinitions());
            existingWord.getPronunciations().addAll(word.getPronunciations());

            word = existingWord;
        }

        // Lưu word vào file
        saveWordToFile(word);
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
            deleteWordFile(keyword);
        }
    }

    @Override
    public void export(String filePath) {
        if (words.isEmpty()) {
            System.out.println("Dictionary is empty. Nothing to export.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            int total = words.size();
            int current = 0;

            System.out.print("Exporting ");

            for (Word word : words) {

                writer.write(word.toString());
                writer.newLine();
                writer.write("------------------------------------");
                writer.newLine();

                current++;
                int percent = (current * 100) / total;

                // In progress mỗi 10%
                if (percent % 10 == 0 || percent == 100) {
                    System.out.print(percent + "%..");
                }
            }

            System.out.println("Done!");
            System.out.println("Export successfully to: " + filePath);

        } catch (IOException e) {
            System.out.println("Export failed: " + e.getMessage());
        }
    }
}