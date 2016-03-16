package care24.com.core.model.request;

import care24.com.core.model.volleyconfig.IVolleyResponsePublisher;

/**
 * Created by mohanish on 3/16/16.
 */
public interface IDataModelRequest extends IVolleyResponsePublisher {

    void getData(String tag);

}
