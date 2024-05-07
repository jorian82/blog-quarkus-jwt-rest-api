package responses;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jra, SSDE Inc
 * on Sun, Apr 21 2024
 * at 17:54, blog-api
 */
public class ResponseRest {
    private final ArrayList<HashMap<String, Object>> metadata = new ArrayList<>();

    public ArrayList<HashMap<String, Object>> getMetadata() {
        return metadata;
    }

    public void setMetadata(String type, int code, String message) {
        HashMap<String, Object> map = new HashMap<>();

        map.put("type", type);
        map.put("code", code);
        map.put("message", message);

        metadata.add(map);
    }
}
