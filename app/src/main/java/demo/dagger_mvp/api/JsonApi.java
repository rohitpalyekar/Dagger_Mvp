package demo.dagger_mvp.api;

import demo.dagger_mvp.model.apimodel.ApiGetDemo;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by sony on 26-04-2018.
 */

public interface JsonApi {

    @GET("Get_demo.php")
    Observable<ApiGetDemo> getResponse(@Query("version_demo") String version);



}
