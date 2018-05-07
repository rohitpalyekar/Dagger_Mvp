package demo.dagger_mvp.model.apimodel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sony on 05-05-2018.
 */

public class BannerItemsModel implements Parcelable {

    @SerializedName("banner_url")
    @Expose
    private String banner_url;

    @SerializedName("banner_data")
    @Expose
    private String banner_data;


    public BannerItemsModel(String banner_url, String banner_data) {
        this.banner_url = banner_url;
        this.banner_data = banner_data;
    }

    protected BannerItemsModel(Parcel in) {
        banner_url = in.readString();
        banner_data = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(banner_url);
        dest.writeString(banner_data);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BannerItemsModel> CREATOR = new Creator<BannerItemsModel>() {
        @Override
        public BannerItemsModel createFromParcel(Parcel in) {
            return new BannerItemsModel(in);
        }

        @Override
        public BannerItemsModel[] newArray(int size) {
            return new BannerItemsModel[size];
        }
    };

    public String getBanner_url() {
        return banner_url;
    }

    public void setBanner_url(String banner_url) {
        this.banner_url = banner_url;
    }

    public String getBanner_data() {
        return banner_data;
    }

    public void setBanner_data(String banner_data) {
        this.banner_data = banner_data;
    }
}


