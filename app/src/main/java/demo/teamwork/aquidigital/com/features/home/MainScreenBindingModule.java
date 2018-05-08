package demo.teamwork.aquidigital.com.features.home;

import com.bluelinelabs.conductor.Controller;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import demo.teamwork.aquidigital.com.common.di.ControllerKey;
import demo.teamwork.aquidigital.com.features.projects.ProjectsComponent;
import demo.teamwork.aquidigital.com.features.projects.ProjectsController;

@Module(subcomponents = {ProjectsComponent.class,
})
public abstract class MainScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(ProjectsController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindProjectsInjector(ProjectsComponent.Builder builder);
}
