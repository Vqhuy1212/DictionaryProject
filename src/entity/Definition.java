package entity;

import java.io.Serializable;

public abstract class Definition implements DictionaryEntry, Serializable {

    private static final long serialVersionUID = 1L;

    // Nghĩa của từ
    protected String meaning;

    // Câu ví dụ
    protected String sentence;

    // Nghĩa của câu ví dụ
    protected String sentenceMeaning;

    /**
     * Constructor
     */
    public Definition(String meaning,
                      String sentence,
                      String sentenceMeaning) {

        this.meaning = meaning;
        this.sentence = sentence;
        this.sentenceMeaning = sentenceMeaning;
    }

    /**
     * Trả về loại định nghĩa
     */
    public abstract String getType();

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getSentenceMeaning() {
        return sentenceMeaning;
    }

    public void setSentenceMeaning(String sentenceMeaning) {
        this.sentenceMeaning = sentenceMeaning;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append("- ").append(meaning);

        if (sentence != null && !sentence.isEmpty()) {

            builder.append("\n= ")
                    .append(sentence);

            if (sentenceMeaning != null && !sentenceMeaning.isEmpty()) {

                builder.append(" + ")
                        .append(sentenceMeaning);
            }
        }

        return builder.toString();
    }

}