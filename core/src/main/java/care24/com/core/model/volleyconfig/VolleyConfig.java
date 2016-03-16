package care24.com.core.model.volleyconfig;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

import care24.com.core.model.CommonContainer;

/**
 * Created by mohanish on 3/16/16.
 */
public class VolleyConfig<T> {

    private IVolleyResponsePublisher responsePublisher;
    private T responseModel;

    public VolleyConfig(IVolleyResponsePublisher responsePublisher, T clazz) {
        this.responsePublisher = responsePublisher;
        this.responseModel = clazz;
    }

    public void getJSONObjectRequest(final String tag_json_obj, final String serviceName) {
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                CommonContainer.BASE_URL + serviceName, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(tag_json_obj, response.toString());
                        responsePublisher.onResponse(getJSONObjectResponeModel(response, responseModel));
                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(tag_json_obj, "Error: " + error.getMessage());
                        responsePublisher.onFailure(error);
                    }
                });
        // Adding request to request queue
        VolleyConfitRequestQueue.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
    }

    public void getJSONArrayRequest(final String tag_json_arr) {
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(
                CommonContainer.BASE_URL,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(tag_json_arr, response.toString());
                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(tag_json_arr, "Error: " + error.getMessage());
                    }
                });
    }

    private T getJSONObjectResponeModel(JSONObject response, T clazz) {
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC);
        return builder.create().fromJson(response.toString(), (Class<T>) clazz);
    }
}
