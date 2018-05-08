package demo.teamwork.aquidigital.com.common.network;

import java.util.List;

import javax.inject.Inject;

import demo.teamwork.aquidigital.com.common.model.Project;
import demo.teamwork.aquidigital.com.common.model.Response;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class ProjectRequester {

    private final ProjectsService projectsService;

    @Inject
    public ProjectRequester(ProjectsService projectsService) {
        this.projectsService = projectsService;
    }

    Single<List<Project>> getProjects(){
        return projectsService.getProjects()
                .map(Response::projects)
                .subscribeOn(Schedulers.io());
    }
}
