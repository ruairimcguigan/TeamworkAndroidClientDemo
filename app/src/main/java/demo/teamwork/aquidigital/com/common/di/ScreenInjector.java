package demo.teamwork.aquidigital.com.common.di;

import android.app.Activity;

import com.bluelinelabs.conductor.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.android.AndroidInjector;
import demo.teamwork.aquidigital.com.common.base.BaseActivity;
import demo.teamwork.aquidigital.com.common.base.BaseController;

@ActivityScope
public class ScreenInjector {

    private final Map<Class<? extends Controller>, Provider<AndroidInjector.Factory<? extends Controller>>> screenInjector;
    private final Map<String, AndroidInjector<Controller>> cache = new HashMap<>();

    @Inject
    public ScreenInjector(Map<Class<? extends Controller>, Provider<AndroidInjector.Factory<? extends Controller>>> screenInjector) {
        this.screenInjector = screenInjector;
    }

    void inject(Controller controller){
        if (!(controller instanceof BaseController)){
            throw new IllegalArgumentException("Controller must extend BaseController");
        }

        String instanceId = controller.getInstanceId();
        if (cache.containsKey(instanceId)){
            cache.get(instanceId).inject(controller);
        }

        AndroidInjector.Factory<Controller> injectorFactory = (AndroidInjector.Factory<Controller>) screenInjector.get(controller.getClass()).get();
        AndroidInjector<Controller> injector = injectorFactory.create(controller);

        cache.put(instanceId, injector);
        injector.inject(controller);
    }

    void clear(Controller controller){
        cache.remove(controller.getInstanceId());
    }

    static ScreenInjector get(Activity activity){
        if (!(activity instanceof BaseActivity)){
            throw new IllegalArgumentException("Controller must be hosted by BaseActivity");
        }
        return ((BaseActivity) activity).getScreenInjector();
    }


}
