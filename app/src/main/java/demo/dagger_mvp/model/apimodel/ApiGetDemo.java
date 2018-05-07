package demo.dagger_mvp.model.apimodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sony on 25-04-2018.
 */

public class ApiGetDemo {
    @SerializedName("retro_source")
    @Expose (deserialize = false)
    private ItemListActivityModel retro_source;

    public ApiGetDemo(ItemListActivityModel retro_source) {
        this.retro_source = retro_source;
    }

    public ItemListActivityModel getRetro_source() {
        return retro_source;
    }

    public void setRetro_source(ItemListActivityModel retro_source) {
        this.retro_source = retro_source;
    }
}
