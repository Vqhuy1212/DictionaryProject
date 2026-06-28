package model;

import java.util.ArrayList;
import java.util.List;

public class Request {

    // Hành động người dùng muốn thực hiện
    private String action;

    // Mục từ
    private String keyword;

    // Các tham số bổ sung
    private List<String> params;

    /**
     * Constructor đầy đủ
     */
    public Request(String action, String keyword, List<String> params) {

        this.action = action;
        this.keyword = keyword;
        this.params = params;
    }

    /**
     * Constructor mặc định
     */
    public Request() {
        params = new ArrayList<>();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

    /**
     * Thêm một tham số
     */
    public void addParam(String param) {
        params.add(param);
    }

    @Override
    public String toString() {

        return "Request{" +
                "action='" + action + '\'' +
                ", keyword='" + keyword + '\'' +
                ", params=" + params +
                '}';
    }
}