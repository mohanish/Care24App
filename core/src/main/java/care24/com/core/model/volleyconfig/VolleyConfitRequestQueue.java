package care24.com.core.model.volleyconfig;

import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import care24.com.core.model.CommonContainer;

/**
 * Created by mohanish on 3/16/16.
 */
public class VolleyConfitRequestQueue {

    private static final String TAG = VolleyConfitRequestQueue.class.getSimpleName();

    private RequestQueue mRequestQueue;

    private static VolleyConfitRequestQueue mInstance;

    private VolleyConfitRequestQueue(){}

    public static synchronized VolleyConfitRequestQueue getInstance() {
        if (null == mInstance)
            mInstance = new VolleyConfitRequestQueue();

        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(CommonContainer.mContext);
        }

        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
