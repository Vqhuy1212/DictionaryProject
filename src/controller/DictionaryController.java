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

        System.out.print("Action: ");

        String input = scanner.nextLine();

        Request request = parseRequest(input);

        System.out.println(request);

    }

    /**
     * Chuyển chuỗi người dùng nhập thành đối tượng Request
     */
    private Request parseRequest(String input) {

        Request request = new Request();

        // Tách chuỗi theo khoảng trắng
        String[] tokens = input.split(" ");

        // Action luôn là từ đầu tiên
        request.setAction(tokens[0]);

        // Keyword luôn là từ cuối cùng
        request.setKeyword(tokens[tokens.length - 1]);

        for (int i = 1; i < tokens.length - 1; i++) {

            request.addParam(tokens[i]);

        }

        return request;
    }
}