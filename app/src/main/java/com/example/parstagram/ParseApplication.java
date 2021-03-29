package com.example.parstagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("rQW8NPYuNkss22N2sO7IPDsRKutBlnNdHJsx4nYf")
                .clientKey("Cy3et2EwvQgvCVvKdaHz4WqIUcnAX3sSE2hl8goP")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
