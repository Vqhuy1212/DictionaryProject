package entity;

import java.io.Serializable;
import java.util.LinkedList;

public class Word implements Serializable {

    private static final long serialVersionUID = 1L;

    // Từ khóa
    private String keyword;

    // Danh sách phát âm
    private LinkedList<Pronunciation> pronunciations;

    // Danh sách định nghĩa
    private LinkedList<Definition> definitions;

    /**
     * Constructor
     */
    public Word(String keyword) {

        this.keyword = keyword;

        pronunciations = new LinkedList<>();
        definitions = new LinkedList<>();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public LinkedList<Pronunciation> getPronunciations() {
        return pronunciations;
    }

    public LinkedList<Definition> getDefinitions() {
        return definitions;
    }

    /**
     * Thêm phát âm
     */
    public void addPronunciation(Pronunciation pronunciation) {
        pronunciations.add(pronunciation);
    }

    /**
     * Thêm định nghĩa
     */
    public void addDefinition(Definition definition) {
        definitions.add(definition);
    }

    /**
     * Xóa định nghĩa
     */
    public void removeDefinition(Definition definition) {
        definitions.remove(definition);
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append("@").append(keyword).append("\n");

        // Hiển thị phát âm
        for (Pronunciation pronunciation : pronunciations) {
            builder.append(pronunciation).append("\n");
        }

        builder.append("\n");

        // Hiển thị các định nghĩa
        for (Definition definition : definitions) {
            builder.append(definition).append("\n\n");
        }

        return builder.toString();
    }
}