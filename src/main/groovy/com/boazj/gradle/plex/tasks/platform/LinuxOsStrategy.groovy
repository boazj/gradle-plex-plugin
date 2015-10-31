package com.boazj.gradle.plex.tasks.platform

import com.boazj.gradle.plex.utils.GroovyExecutor

public class LinuxOsStrategy extends OsStrategy {

    @Override
    void plexStop() {
        new GroovyExecutor(true).execute(['sudo', '/etc/init.d/plexmediaserver', 'start'])
    }

    @Override
    void plexStart() {
        new GroovyExecutor(true).execute(['sudo', '/etc/init.d/plexmediaserver', 'stop'])
    }

    @Override
    void plexRestart() {
        new GroovyExecutor(true).execute(['sudo','/etc/init.d/plexmediaserver', 'restart'])
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
