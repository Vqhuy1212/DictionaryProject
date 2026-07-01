package entity;

import java.io.Serializable;

public class Pronunciation implements DictionaryEntry, Serializable {

    private static final long serialVersionUID = 1L;

    // Phiên âm IPA của từ
    private String ipa;

    /**
     * Constructor
     * @param ipa Phiên âm IPA
     */
    public Pronunciation(String ipa) {
        this.ipa = ipa;
    }

    /**
     * Lấy phiên âm
     */
    public String getIpa() {
        return ipa;
    }

    /**
     * Cập nhật phiên âm
     */
    public void setIpa(String ipa) {
        this.ipa = ipa;
    }

    /**
     * Hiển thị thông tin đối tượng
     */
    @Override
    public String toString() {
        return "/" + ipa + "/";
    }
}