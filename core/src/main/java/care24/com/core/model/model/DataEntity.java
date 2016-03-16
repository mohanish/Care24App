package care24.com.core.model.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mohanish on 3/15/16.
 */
@Table(name = "Care24Data")
public class DataEntity extends Model {

    @Column(name = "_id")
    private String _id;

    @Expose
    @SerializedName("uri")
    @Column(name = "imageUri")
    private String uri;

    @SerializedName("title")
    @Expose
    @Column(name = "title")
    private String title;

    public DataEntity() {
        super();
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String get_id() {
        return _id;
    }

    public String getUri() {
        return uri;
    }

    public String getTitle() {
        return title;
    }
}
