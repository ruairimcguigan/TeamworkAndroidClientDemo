package demo.teamwork.aquidigital.com.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;

import javax.inject.Inject;

import demo.teamwork.aquidigital.com.common.di.ActivityScope;

@ActivityScope
public class DefaultScreenNavigator implements ScreenNavigator {

    private Router router;

    @Inject
    DefaultScreenNavigator(){

    }

    @Override
    public void initWithRouter(Router router, Controller rootScreen) {
        this.router = router;
        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(rootScreen));
        }
    }

    @Override
    public boolean pop() {
        return router != null && router.handleBack();
    }

    @Override
    public void clear() {

    }
}
