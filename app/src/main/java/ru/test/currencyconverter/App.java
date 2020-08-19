package ru.test.currencyconverter;

import android.app.Application;
import android.os.SystemClock;

import java.util.concurrent.TimeUnit;

import ru.test.currencyconverter.currency.CourseLoader;

public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        CourseLoader courseLoader = new CourseLoader(getResources().getString(R.string.cbr_json));

        courseLoader.start();
        try {
            courseLoader.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Don't do this! This is just so cold launches take some time
        //SystemClock.sleep(TimeUnit.SECONDS.toMillis(3));
    }
}