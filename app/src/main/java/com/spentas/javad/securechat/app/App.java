package com.spentas.javad.securechat.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;

import com.spentas.javad.securechat.network.websocket.Connection;
import com.spentas.javad.securechat.network.websocket.ConnectionManager;
import com.spentas.javad.securechat.sqlite.SharedPreference;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;


/**
 * Created by javad on 10/29/2015.
 */
public class App extends Application {
    @Inject
    ConnectionManager connectionManager;
    private AppComponent component;
    private Connection connection;
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        component = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        onActivityLifecycleCallback();
        component.inject(this);
    }


    public static Context getContext(){
        return mContext;
    }

    public Connection getConnection(){
        return connectionManager.getConnection(ConnectionManager.ConnectionType.WEBSOCKET);
    }

    public AppComponent getComponent(){
        return component;
    }

    private void onActivityLifecycleCallback() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }

            @Override
            public void onActivityStarted(Activity activity) {
                Log.i("APP","activity start");

            }

            @Override
            public void onActivityResumed(Activity activity) {
                Log.i("APP","activity resumed");
            }

            @Override
            public void onActivityPaused(Activity activity) {
                Log.i("APP","activity paused");

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }

        });
    }

}
