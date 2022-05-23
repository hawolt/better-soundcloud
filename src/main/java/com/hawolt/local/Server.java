package com.hawolt.local;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

/**
 * Created: 17/05/2022 23:16
 * Author: Twitter @hawolt
 **/

public class Server {
    public static void run() {
        Javalin.create(config -> config.addStaticFiles("/public", Location.CLASSPATH)).start(7000);
    }
}
