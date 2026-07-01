package controller;

import model.Request;
import service.DictionaryService;

import java.util.Scanner;

public class DictionaryController {

    private Scanner scanner;

    private DictionaryService service;

    public DictionaryController() {

        scanner = new Scanner(System.in);

        service = DictionaryService.getInstance();

    }

    public void start() {

        while (true) {

            System.out.print("Action: ");

            String input = scanner.nextLine().trim();

            // Bỏ qua input rỗng
            if (input.isEmpty()) {
                continue;
            }

            Request request = parseRequest(input);

            handleRequest(request);
        }

    }

    /**
     * Chuyển chuỗi người dùng nhập thành đối tượng Request
     */
    private Request parseRequest(String input) {

        Request request = new Request();

        // Tách chuỗi theo khoảng trắng
        String[] tokens = input.split("\\s+");

        // Action luôn là từ đầu tiên
        request.setAction(tokens[0]);

        // Xác định keyword & params tùy theo action
        String action = tokens[0].toLowerCase();

        if (action.equals("define")) {
            // define -type keyword ...
            if (tokens.length < 3) {
                System.out.println("Usage: define -type keyword");
                return request;
            }

            // Params bao gồm type flag và keyword
            for (int i = 1; i < tokens.length; i++) {
                request.addParam(tokens[i]);
            }

            // Keyword là phần tử thứ 2 (index 2)
            request.setKeyword(tokens[2]);

        } else if (action.equals("lookup") || action.equals("drop")) {
            // lookup keyword / drop keyword
            if (tokens.length < 2) {
                System.out.println("Usage: " + action + " keyword");
                return request;
            }

            request.setKeyword(tokens[1]);

        } else if (action.equals("export")) {
            // export filepath
            if (tokens.length < 2) {
                System.out.println("Usage: export filepath");
                return request;
            }

            request.setKeyword(tokens[1]);

        } else {
            // Các action khác (exit, quit, etc.)
            if (tokens.length > 1) {
                request.setKeyword(tokens[1]);
            }
        }

        return request;
    }

    /**
     * Xử lý request dựa trên action
     */
    private void handleRequest(Request request) {

        String action = request.getAction().toLowerCase();
        String keyword = request.getKeyword();
        java.util.List<String> params = request.getParams();

        switch (action) {

            case "lookup":
                handleLookup(keyword);
                break;

            case "define":
                handleDefine(keyword, params);
                break;

            case "drop":
                handleDrop(keyword);
                break;

            case "export":
                handleExport(keyword);
                break;

            case "exit":
            case "quit":
                System.out.println("Goodbye!");
                System.exit(0);
                break;

            default:
                System.out.println("Unknown action: " + action);
                break;
        }
    }

    /**
     * Xử lý action lookup
     */
    private void handleLookup(String keyword) {

        if (keyword == null || keyword.isEmpty()) {
            System.out.println("Please provide a keyword to lookup.");
            return;
        }

        entity.Word word = service.lookup(keyword);

        if (word == null) {
            System.out.println("@" + keyword + " not found in dictionary!");
        } else {
            System.out.println(word);
        }
    }

    /**
     * Xử lý action define
     */
    private void handleDefine(String keyword, java.util.List<String> params) {

        if (keyword == null || keyword.isEmpty()) {
            System.out.println("Please provide a keyword to define.");
            return;
        }

        if (params.isEmpty()) {
            System.out.println("Please provide definition type (e.g., -n, --noun, -a, --adjective, -v, --verb, -s, --synonymous, -p, --pronoun).");
            return;
        }

        // params[0] là loại định nghĩa (-n, -a, -v, -s, -p)
        String typeFlag = params.get(0);

        // Kiểm tra loại định nghĩa có hợp lệ không
        if (!factory.DictionaryFactory.isValidTypeFlag(typeFlag)) {
            System.out.println("Invalid definition type: " + typeFlag);
            System.out.println("Valid types: -p (--pronoun), -n (--noun), -a (--adjective), -v (--verb), -s (--synonymous)");
            return;
        }

        // Kiểm tra xem từ đã tồn tại chưa
        entity.Word existingWord = service.lookup(keyword);
        if (existingWord == null) {
            System.out.println("@" + keyword + " is not existed in database, created new one!");
        } else {
            System.out.println("@" + keyword + " is already existed in database.");
        }

        // Thu thập thông tin từ user
        java.util.List<String> entryParams = new java.util.ArrayList<>();

        // Loại định nghĩa
        System.out.print(getDefinitionTypeLabel(typeFlag) + " definition: ");
        String meaning = scanner.nextLine();
        entryParams.add(meaning);

        // Chỉ hỏi về sentence và sentenceMeaning nếu không phải phát âm hay đồng nghĩa
        if (!typeFlag.equals("-p") && !typeFlag.equals("--pronoun") &&
                !typeFlag.equals("-s") && !typeFlag.equals("--synonymous")) {

            System.out.print("Sentence: ");
            String sentence = scanner.nextLine().trim();
            entryParams.add(sentence);

            if (!sentence.isEmpty()) {
                System.out.print("Sentence's meaning: ");
                String sentenceMeaning = scanner.nextLine();
                entryParams.add(sentenceMeaning);
            } else {
                entryParams.add("");
            }

        }

        // Tạo entry (Definition hoặc Pronunciation) bằng factory
        entity.DictionaryEntry entry = factory.DictionaryFactory.createEntry(typeFlag, entryParams);

        if (entry == null) {
            System.out.println("Failed to create entry!");
            return;
        }

        // Tạo hoặc cập nhật word
        entity.Word word;
        if (existingWord != null) {
            word = existingWord;
        } else {
            word = factory.DictionaryFactory.createWord(keyword);
        }

        // Thêm entry vào word
        if (entry instanceof entity.Pronunciation) {
            word.addPronunciation((entity.Pronunciation) entry);
        } else if (entry instanceof entity.Definition) {
            word.addDefinition((entity.Definition) entry);
        }

        // Lưu word vào service
        service.define(word);

        System.out.println("Saved!");
    }

    /**
     * Xử lý action drop
     */
    private void handleDrop(String keyword) {

        if (keyword == null || keyword.isEmpty()) {
            System.out.println("Please provide a keyword to drop.");
            return;
        }

        entity.Word word = service.lookup(keyword);

        if (word == null) {
            System.out.println("@" + keyword + " not found in dictionary!");
            return;
        }

        service.drop(keyword);
        System.out.println("@" + keyword + " dropped!");
    }

    /**
     * Xử lý action export
     */
    private void handleExport(String filePath) {

        if (filePath == null || filePath.isEmpty()) {
            System.out.println("Please provide a file path to export.");
            return;
        }

        service.export(filePath);
    }

    /**
     * Lấy nhãn loại định nghĩa để hiển thị
     */
    private String getDefinitionTypeLabel(String typeFlag) {

        switch (typeFlag) {
            case "-p":
            case "--pronoun":
                return "Pronunciation";
            case "-n":
            case "--noun":
                return "Noun";
            case "-a":
            case "--adjective":
                return "Adjective";
            case "-v":
            case "--verb":
                return "Verb";
            case "-s":
            case "--synonymous":
                return "Synonymous";
            default:
                return "Definition";
        }
    }
}