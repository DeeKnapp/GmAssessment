package com.example.gm.assessment.dagger;

import android.content.Context;

import com.example.gm.assessment.MyApplication;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final MyApplication app;

    public AppModule(MyApplication app) {
        this.app = app;
    }

    @Provides
    @Singleton
    @Named("application")
    Context context() {
        return app.getApplicationContext();
    }

    @Provides @Singleton MyApplication application() {
        return app;
    }

}
