package test.com.lexin.dewcrew.parser;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Sair on 5/3/2016.
 */
public interface IParser {
    public Object parseData(JSONObject jsonObject);
}
