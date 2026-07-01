package entity;

public class Pronunciation implements DictionaryEntry {

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
        return ipa;
    }
}