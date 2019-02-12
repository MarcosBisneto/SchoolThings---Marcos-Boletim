package com.app.boletim.AppBancoDados;

/**
 * Created by Marcos Mac on 16/12/18.
 */

import android.app.Application;
import android.util.Log;

import com.app.boletim.BuildConfig;
import com.app.boletim.Modelos.MyObjectBox;

import io.objectbox.BoxStore;
import io.objectbox.android.AndroidObjectBrowser;

public class App extends Application {

    public static final String TAG = "ObjectBoxExample";
    public static final boolean EXTERNAL_DIR = false;

    private BoxStore boxStore;

    @Override
    public void onCreate() {
        super.onCreate();

        boxStore = MyObjectBox.builder().androidContext(App.this).build();
        if (BuildConfig.DEBUG) {
            new AndroidObjectBrowser(boxStore).start(this);
        }

        Log.d("App", "Using ObjectBox " + BoxStore.getVersion() + " (" + BoxStore.getVersionNative() + ")");
    }

    public BoxStore getBoxStore() {
        return boxStore;
    }
}