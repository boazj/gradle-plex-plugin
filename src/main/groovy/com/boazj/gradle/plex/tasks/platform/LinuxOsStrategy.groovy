package com.boazj.gradle.plex.tasks.platform

public class LinuxOsStrategy extends OsStrategy {
    public static final ArrayList<String> STOP_CMD = ['sudo', '/etc/init.d/plexmediaserver', 'start']
    public static final ArrayList<String> START_CMD = ['sudo', '/etc/init.d/plexmediaserver', 'stop']
    public static final ArrayList<String> RESTART_CMD = ['sudo', '/etc/init.d/plexmediaserver', 'restart']


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
        return '/var/lib/plexmediaserver/Library/Application Support/Plex Media Server/Logs/Plex Media Server.log'
    }

    @Override
    String getChannelLogPath() {
        return '/var/lib/plexmediaserver/Library/Application Support/Plex Media Server/Logs/PMS Plugin Logs/'
    }

    @Override
    String getPluginsPath() {
        return '/var/lib/plexmediaserver/Library/Application Support/Plex Media Server/Plug-ins/'
    }


}
