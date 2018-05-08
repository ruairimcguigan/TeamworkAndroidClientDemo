package demo.teamwork.aquidigital.com.common.network;

import demo.teamwork.aquidigital.com.common.model.Response;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface ProjectsService {

    @GET("/projects.json")
    Single<Response> getProjects();
}
