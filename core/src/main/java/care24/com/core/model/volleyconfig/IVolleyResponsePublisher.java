package care24.com.core.model.volleyconfig;

import com.android.volley.VolleyError;

import care24.com.core.model.IregisterResponse;

/**
 * Created by mohanish on 3/16/16.
 */
public interface IVolleyResponsePublisher<T>{

    void onResponse(T clazz);

    void onFailure(VolleyError error);
}
