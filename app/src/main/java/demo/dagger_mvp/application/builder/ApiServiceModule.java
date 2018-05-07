package demo.dagger_mvp.application.builder;

import dagger.Module;
import dagger.Provides;
import demo.dagger_mvp.api.JsonApi;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sony on 25-04-2018.
 */

@Module
public class ApiServiceModule {

    private static final String BASE_URL = "http://www.ampereunit.com/demo/";

    @AppScope
    @Provides
    JsonApi provideApiService(OkHttpClient client, GsonConverterFactory gson, RxJavaCallAdapterFactory rxAdapter)
    {
        Retrofit retrofit =   new Retrofit.Builder().client(client)
                .baseUrl(BASE_URL).addConverterFactory(gson).
                        addCallAdapterFactory(rxAdapter).build();

        return  retrofit.create(JsonApi.class);
    }
}
