package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
    public static Object[][] getJSONdata(String JSON_path, String JSON_data, int JSON_attributes) throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader((JSON_path)));
        JSONObject jo = (JSONObject) obj;
        JSONArray js = (JSONArray) jo.get(JSON_data);

        Object[][] arr = new String[js.size()][JSON_attributes];
        for (int i = 0; i < js.size(); i++) {
            JSONObject obj1 = (JSONObject) js.get(i);
            arr[i][0] = String.valueOf(obj1.get("countryName"));
            arr[i][1] = String.valueOf(obj1.get("currency"));
            arr[i][2] = String.valueOf(obj1.get("firstPackage"));
            arr[i][3] = String.valueOf(obj1.get("secondPackage"));
            arr[i][4] = String.valueOf(obj1.get("thirdPackage"));
            arr[i][5] = String.valueOf(obj1.get("LitePrice"));
            arr[i][6] = String.valueOf(obj1.get("ClassicPrice"));
            arr[i][7] = String.valueOf(obj1.get("PremiumPrice"));
        }
        return arr;
    }
}
