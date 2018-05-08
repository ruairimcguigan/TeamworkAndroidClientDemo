package demo.teamwork.aquidigital.com.common.network;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.teamwork.aquidigital.com.networking.NetworkModule;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module (includes = NetworkModule.class)
public abstract class ServiceModule {

    @Provides
    @Singleton
    static Retrofit provideRetrofit(OkHttpClient client, Call.Factory callFactory, @Named("base_url") String baseUrl){
        return new Retrofit.Builder()
                .client(client)
                .callFactory(callFactory)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }
    @Provides
    @Singleton
    static ProjectsService provideProjectsService(Retrofit retrofit){
        return retrofit.create(ProjectsService.class);
    }
}
