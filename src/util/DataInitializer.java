package util;

import entity.Word;
import entity.NounDefinition;
import entity.AdjectiveDefinition;
import entity.VerbDefinition;
import entity.Pronunciation;
import service.DictionaryService;

/**
 * Tạo dữ liệu mẫu cho từ điển
 * Chỉ chạy lần đầu tiên khi từ điển trống
 */
public class DataInitializer {

    public static void initializeSampleData(DictionaryService service) {
        System.out.println("Initializing sample data...");

        // Từ 1: positive
        Word positive = new Word("positive");
        positive.addPronunciation(new Pronunciation("/'pɔzətiv/"));
        positive.addDefinition(new AdjectiveDefinition("xác thực, rõ ràng", "a positive proof", "một chứng cớ rõ ràng"));
        positive.addDefinition(new AdjectiveDefinition("tích cực", "a positive factor", "một nhân tố tích cực"));
        positive.addDefinition(new NounDefinition("điều xác thực, điều có thực", "", ""));
        service.define(positive);

        // Từ 2: computer
        Word computer = new Word("computer");
        computer.addPronunciation(new Pronunciation("/kəm'pju:tə/"));
        computer.addDefinition(new NounDefinition("máy tính", "I use a computer every day", "Tôi sử dụng máy tính mỗi ngày"));
        computer.addDefinition(new NounDefinition("thiết bị điện tử xử lý dữ liệu", "", ""));
        service.define(computer);

        // Từ 3: beautiful
        Word beautiful = new Word("beautiful");
        beautiful.addPronunciation(new Pronunciation("/'bju:tɪfl/"));
        beautiful.addDefinition(new AdjectiveDefinition("đẹp, quyến rũ", "She has a beautiful smile", "Cô ấy có nụ cười đẹp"));
        beautiful.addDefinition(new AdjectiveDefinition("tuyệt vời, lôi cuốn", "", ""));
        service.define(beautiful);

        // Từ 4: run
        Word run = new Word("run");
        run.addPronunciation(new Pronunciation("/rʌn/"));
        run.addDefinition(new VerbDefinition("chạy", "I run in the morning", "Tôi chạy vào buổi sáng"));
        run.addDefinition(new VerbDefinition("vận hành, điều hành", "She runs a small business", "Cô ấy điều hành một doanh nghiệp nhỏ"));
        service.define(run);

        // Từ 5: happy
        Word happy = new Word("happy");
        happy.addPronunciation(new Pronunciation("/'hæpi/"));
        happy.addDefinition(new AdjectiveDefinition("vui vẻ, hạnh phúc", "I am happy today", "Hôm nay tôi rất vui vẻ"));
        happy.addDefinition(new AdjectiveDefinition("may mắn, thuận lợi", "", ""));
        service.define(happy);

        // Từ 6: book
        Word book = new Word("book");
        book.addPronunciation(new Pronunciation("/bʊk/"));
        book.addDefinition(new NounDefinition("cuốn sách", "I read a book yesterday", "Tôi đọc một cuốn sách hôm qua"));
        book.addDefinition(new VerbDefinition("đặt chỗ, đặt vé", "I will book a flight tomorrow", "Tôi sẽ đặt vé máy bay ngày mai"));
        service.define(book);

        // Từ 7: understand
        Word understand = new Word("understand");
        understand.addPronunciation(new Pronunciation("/ˌʌndə'stænd/"));
        understand.addDefinition(new VerbDefinition("hiểu, nắm bắt", "Do you understand this lesson?", "Bạn có hiểu bài học này không?"));
        understand.addDefinition(new VerbDefinition("biết, được thông báo", "I understand that you will leave", "Tôi biết rằng bạn sẽ đi"));
        service.define(understand);

        System.out.println("✓ Sample data initialized successfully!\n");
    }
}