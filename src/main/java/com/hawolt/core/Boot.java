package com.hawolt.core;

import com.hawolt.local.Server;
import com.hawolt.ui.BSC;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;

import java.io.IOException;

/**
 * Created: 05/04/2022 16:53
 * Author: Twitter @hawolt
 **/

public class Boot {

    public static final long STARTED_AT = System.currentTimeMillis();

    public static void main(String[] args) throws IOException {
        Server.run();
        BSC.create();
        DiscordRPC.discordInitialize("911364247844433941", new DiscordEventHandlers(), true);
        DiscordRichPresence rich = new DiscordRichPresence.Builder("Exploring")
                .setBigImage("bsc-icon", "Better Soundcloud")
                .setStartTimestamps(Boot.STARTED_AT)
                .build();
        DiscordRPC.discordUpdatePresence(rich);
        Runtime.getRuntime().addShutdownHook(new Thread(DiscordRPC::discordShutdown));
    }
}
