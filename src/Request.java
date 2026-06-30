import java.util.List;

/**
 * Request class represents a user action parsed from command line input
 * Contains action, keyword (target word), and parameters for the action
 */
public class Request {
    private String action;
    private String keyword;
    private List<String> params;

    public Request(String action, String keyword, List<String> params) {
        this.action = action;
        this.keyword = keyword;
        this.params = params;
    }

    public String getAction() {
        return action;
    }

    public String getKeyword() {
        return keyword;
    }

    public List<String> getParams() {
        return params;
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
