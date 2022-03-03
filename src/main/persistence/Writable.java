package persistence;

import org.json.JSONObject;

//Codes referenced from JsonSerializationDemo.
public interface Writable {
    //Returns this as a JSON object.
    JSONObject toJson();
}
