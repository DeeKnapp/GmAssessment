package com.example.gm.assessment;

import android.app.Application;

import com.example.gm.assessment.dagger.AppComponent;
import com.example.gm.assessment.dagger.AppModule;
import com.example.gm.assessment.dagger.DaggerAppComponent;

public class MyApplication extends Application {
    private AppComponent component;

    public MyApplication() {
        super();

        component = DaggerAppComponent.builder().appModule(getAppModule()).build();
    }

    private AppModule getAppModule() {
        return new AppModule(this);
    }

    public AppComponent getAppComponent() {
        return component;
    }
}
