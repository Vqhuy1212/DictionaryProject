import controller.DictionaryController;
import service.DictionaryService;
import util.DataInitializer;

public class Main {

    public static void main(String[] args) {

        // Lấy instance singleton của DictionaryService
        DictionaryService service = DictionaryService.getInstance();

        // Kiểm tra xem có dữ liệu chưa
        // Nếu "positive" không tồn tại thì khởi tạo dữ liệu mẫu
        if (service.lookup("positive") == null) {
            DataInitializer.initializeSampleData(service);
        }

        // Bắt đầu ứng dụng chính
        DictionaryController controller = new DictionaryController();
        controller.start();

    }

}