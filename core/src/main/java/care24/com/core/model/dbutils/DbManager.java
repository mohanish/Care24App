package care24.com.core.model.dbutils;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Select;

import java.util.List;

import care24.com.core.model.model.DataEntity;

/**
 * Created by mohanish on 3/16/16.
 */
public class DbManager {

    public static void saveRecord(List<DataEntity> objects) {

        ActiveAndroid.beginTransaction();

        try {

            for (DataEntity dataEntity : objects) {
                dataEntity.save();
            }

            ActiveAndroid.setTransactionSuccessful();

        } finally {
            ActiveAndroid.endTransaction();

        }
    }

    public static List<DataEntity> getAll() {
        return new Select()
                .from(DataEntity.class)
                .where("title IS NOT NULL")
                .execute();
    }


}
