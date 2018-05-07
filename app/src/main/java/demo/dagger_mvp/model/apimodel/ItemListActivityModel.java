package demo.dagger_mvp.model.apimodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by sony on 25-04-2018.
 */

public class ItemListActivityModel {

    @SerializedName("timestamp")
    @Expose (deserialize = false)
    private String timestamp;
    @SerializedName("alert_flag")
    @Expose (deserialize = false)
    private String alert_flag;
    @SerializedName("alert_type")
    @Expose (deserialize = false)
    private String alert_type;
    @SerializedName("alert_meaage")
    @Expose (deserialize = false)
    private String alert_message;

    @SerializedName("source_items")
    @Expose
    private ArrayList<SourceItemsModel> source_items;

    @SerializedName("banners")
    @Expose
    private ArrayList<BannerItemsModel> banners;

    public ItemListActivityModel(String timestamp, String alert_flag, String alert_type, String alert_message, ArrayList<SourceItemsModel> source_items, ArrayList<BannerItemsModel> banners) {
        this.timestamp = timestamp;
        this.alert_flag = alert_flag;
        this.alert_type = alert_type;
        this.alert_message = alert_message;
        this.source_items = source_items;
        this.banners=banners;
    }


    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getAlert_flag() {
        return alert_flag;
    }

    public void setAlert_flag(String alert_flag) {
        this.alert_flag = alert_flag;
    }

    public String getAlert_type() {
        return alert_type;
    }

    public void setAlert_type(String alert_type) {
        this.alert_type = alert_type;
    }

    public String getAlert_message() {
        return alert_message;
    }

    public void setAlert_message(String alert_message) {
        this.alert_message = alert_message;
    }

    public ArrayList<SourceItemsModel> getSource_items() {
        return source_items;
    }

    public void setSource_items(ArrayList<SourceItemsModel> source_items) {
        this.source_items = source_items;
    }

    public ArrayList<BannerItemsModel> getBanners() {
        return banners;
    }

    public void setBanners(ArrayList<BannerItemsModel> banners) {
        this.banners = banners;
    }
}
