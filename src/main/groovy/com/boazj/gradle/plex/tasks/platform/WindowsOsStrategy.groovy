package com.boazj.gradle.plex.tasks.platform

class WindowsOsStrategy extends OsStrategy {

    @Override
    void plexStop() {
        //TODO:
        getExecutors().get(true).execute([])
    }

    @Override
    void plexStart() {
        //TODO:
        getExecutors().get(true).execute([])
    }

    @Override
    void plexRestart() {
        //TODO:
        getExecutors().get(true).execute([])
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