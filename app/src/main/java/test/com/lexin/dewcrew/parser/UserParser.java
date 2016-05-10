package test.com.lexin.dewcrew.parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import test.com.lexin.dewcrew.common.Constants;
import test.com.lexin.dewcrew.model.User;

/**
 * Created by Sair on 5/3/2016.
 */
public class UserParser implements IParser {

    private String data = "[{\"first_name\":\"Jhon\",\"last_name\":\"snow\"},{\"first_name\":\"Jhon\",\"last_name\":\"snow\"},{\"first_name\":\"Jhon\",\"last_name\":\"snow\"},{\"first_name\":\"Jhon\",\"last_name\":\"snow\"},{\"first_name\":\"Jhon\",\"last_name\":\"snow\"},{\"first_name\":\"Jhon\",\"last_name\":\"snow\"}]";

    @Override
    public Object parseData(JSONObject jsonObject) {
        JSONArray users;
        ArrayList<User> userArrayList = new ArrayList<>();
        try {
            users = new JSONArray(data);

            for (int i = 0; i < users.length(); i++) {
                JSONObject userObject = (JSONObject) users.get(i);
                User user = new User();
                if (userObject.has(Constants.JSON_KEY_FIRST_NAME)) {
                    user.setFirstName(userObject.getString(Constants.JSON_KEY_FIRST_NAME));
                }
                if (userObject.has(Constants.JSON_KEY_LAST_NAME)) {
                    user.setLastName(userObject.getString(Constants.JSON_KEY_LAST_NAME));
                }
                userArrayList.add(user);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return userArrayList;
    }


}
