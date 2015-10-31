package com.boazj.gradle.plex.tasks.platform

import com.boazj.gradle.plex.utils.GroovyExecutor

class WindowsOsStrategy extends OsStrategy {

    @Override
    void plexStop() {
        //TODO:
        new GroovyExecutor(true).execute([])
    }

    @Override
    void plexStart() {
        //TODO:
        new GroovyExecutor(true).execute([])
    }

    @Override
    void plexRestart() {
        //TODO:
        new GroovyExecutor(true).execute([])
    }

    @Override
    String getPlexLogPath() {
        return "${System.getenv("APPDATA")}\\Plex Media Server\\Logs\\Plex Media Server.log"
    }

    @Override
    String getChannelLogPath() {
        return "${System.getenv("APPDATA")}\\Plex Media Server\\Logs\\PMS Plugin Logs\\"
    }

    @Override
    String getPluginsPath() {
        return "${System.getenv("APPDATA")}\\Plex Media Server\\Plug-ins\\"
    }

}