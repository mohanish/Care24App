package care24.com.core.model.model;

import java.util.List;

/**
 * Created by mohanish on 3/15/16.
 */
public class DataModel {


    /**
     * result_count : 240
     * data : [{"id":"597308825","uri":"http://cache4.asset-cache.net/xt/597308825.jpg?v=1&g=fs1|0|EYM|08|825&s=1&b=RjI4","title":"Close-Up Of Insect Pollinating On Pink Flower"}]
     */

    private int result_count;
    /**
     * id : 597308825
     * uri : http://cache4.asset-cache.net/xt/597308825.jpg?v=1&g=fs1|0|EYM|08|825&s=1&b=RjI4
     * title : Close-Up Of Insect Pollinating On Pink Flower
     */

    private List<DataEntity> data;

    public void setResult_count(int result_count) {
        this.result_count = result_count;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public int getResult_count() {
        return result_count;
    }

    public List<DataEntity> getData() {
        return data;
    }

}
