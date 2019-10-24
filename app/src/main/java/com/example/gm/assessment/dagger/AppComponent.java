package com.example.gm.assessment.dagger;

import com.example.gm.assessment.activities.MainActivity;

import dagger.Component;

@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(MainActivity main);
}
