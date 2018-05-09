package demo.teamwork.aquidigital.com.common.di;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.bluelinelabs.conductor.Controller;

public class Injector {

    private Injector() {

    }

    public static void inject (Activity activity){
        ActivityInjector.get(activity);
    }

    public static void clearComponent(Activity activity) {
        ActivityInjector.get(activity).clear(activity);
    }

    public static void inject (Fragment controller){
        ScreenInjector.get(controller.getActivity()).inject(controller);

    }

    public static void clearComponent(Fragment controller) {
//        ScreenInjector.get(controller.getActivity()).clear(controller);

    }


}
