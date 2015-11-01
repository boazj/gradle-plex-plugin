package com.boazj.gradle.plex.tasks.platform

class MacOsStrategy extends OsStrategy {


    public static final ArrayList<String> STOP_CMD = ['killall', 'Plex Media Server']
    public static final ArrayList<String> START_CMD = ['open', '/Applications/Plex Media Server.app']
    public static final ArrayList<String> RESTART_CMD = ['killall', 'Plex Media Server', ';', 'sleep', '5', ';', 'open', '/Applications/Plex Media Server.app']

    @Override
    void plexStop() {
        getExecutors().get(true).execute(STOP_CMD)
    }

    @Override
    void plexStart() {
        getExecutors().get(true).execute(START_CMD)
    }

    @Override
    void plexRestart() {
        getExecutors().get(true).execute(RESTART_CMD)
    }

    @Override
    String getPlexLogPath() {
        return "${System.getProperty('user.home')}/Library/Application Support/Plex Media Server/Logs/Plex Media Server.log"
    }

    @Override
    String getChannelLogPath() {
        return "${System.getProperty('user.home')}/Library/Application Support/Plex Media Server/Logs/PMS Plugin Logs/"
    }

    @Override
    String getPluginsPath() {
        return "${System.getProperty('user.home')}/Library/Application Support/Plex Media Server/Plug-ins/"
    }
}