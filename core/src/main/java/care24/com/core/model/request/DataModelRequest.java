package care24.com.core.model.request;

import com.android.volley.VolleyError;

import care24.com.core.model.IregisterResponse;
import care24.com.core.model.dbutils.DbManager;
import care24.com.core.model.model.DataModel;
import care24.com.core.model.volleyconfig.VolleyConfig;

/**
 * Created by mohanish on 3/16/16.
 */
public class DataModelRequest implements IDataModelRequest {

    IregisterResponse mResponse;

    @Override
    public void onResponse(Object clazz) {
        DbManager.saveRecord(((DataModel) clazz).getData());
        if (null != mResponse) mResponse.registerResponse();
    }

    @Override
    public void onFailure(VolleyError error) {

    }

    @Override
    public void getData(String tag) {
        VolleyConfig volleyConfig = new VolleyConfig(this, DataModel.class);
        volleyConfig.getJSONObjectRequest(tag, "getData");
    }


    public void registerResponse(IregisterResponse iregisterResponse) {
        this.mResponse = iregisterResponse;
    }

    public void unRegisterRespoonse() {
        this.mResponse = null;
    }
}
