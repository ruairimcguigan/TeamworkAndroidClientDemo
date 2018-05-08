package demo.teamwork.aquidigital.com.common.base;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;

import demo.teamwork.aquidigital.com.common.di.Injector;

public abstract class BaseController extends Controller{

    private boolean injected = false;

    @Override
    protected void onContextAvailable(@NonNull Context context) {
        /**
         * Controller instances are retained across config changes, so this method can be called
         * more than once. Ensures injection doesn't occur unnecessarily
         */
        if ((!injected)){
            Injector.inject(this);
            injected = true;
        }

        super.onContextAvailable(context);

    }
}
