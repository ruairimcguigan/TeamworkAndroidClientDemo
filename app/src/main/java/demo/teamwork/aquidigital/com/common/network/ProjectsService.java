package demo.teamwork.aquidigital.com.common.network;

import demo.teamwork.aquidigital.com.common.model.Response;
import retrofit2.http.GET;
import rx.Single;

public interface ProjectsService {

    @GET("/projects.json")
    Single<Response> getProjects();
}
