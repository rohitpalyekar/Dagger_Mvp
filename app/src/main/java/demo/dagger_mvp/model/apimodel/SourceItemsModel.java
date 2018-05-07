package demo.dagger_mvp.model.apimodel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sony on 25-04-2018.
 */

public class SourceItemsModel implements Parcelable {

    @SerializedName("item_id")
    @Expose
    private String item_id;

    @SerializedName("item_name")
    @Expose
    private String item_name;

    @SerializedName("item_url")
    @Expose
    private String item_url;

    @SerializedName("feature_flag")
    @Expose
    private String featured_flag;


    public SourceItemsModel(String item_id, String item_name, String item_url, String featured_flag) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.item_url = item_url;
        this.featured_flag=featured_flag;
    }



    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_url() {
        return item_url;
    }

    public void setItem_url(String item_url) {
        this.item_url = item_url;
    }
    public String getFeatured_flag() {
        return featured_flag;
    }

    public void setFeatured_flag(String featured_flag) {
        this.featured_flag = featured_flag;
    }

    protected SourceItemsModel(Parcel in) {
        item_id = in.readString();
        item_name = in.readString();
        item_url = in.readString();
        featured_flag=in.readString();

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(item_id);
        dest.writeString(item_name);
        dest.writeString(item_url);
        dest.writeString(featured_flag);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SourceItemsModel> CREATOR = new Creator<SourceItemsModel>() {
        @Override
        public SourceItemsModel createFromParcel(Parcel in) {
            return new SourceItemsModel(in);
        }

        @Override
        public SourceItemsModel[] newArray(int size) {
            return new SourceItemsModel[size];
        }
    };
}
