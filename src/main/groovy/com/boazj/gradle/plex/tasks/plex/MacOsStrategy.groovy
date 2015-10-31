package com.boazj.gradle.plex.tasks.plex

import com.boazj.gradle.plex.utils.GroovyExecutor

class MacOsStrategy extends OsStrategy {

    @Override
    void plexStop() {
        new GroovyExecutor(true).execute(['killall', 'Plex Media Server'])
    }

    @Override
    void plexStart() {
        new GroovyExecutor(true).execute(['open', '/Applications/Plex Media Server.app'])
    }

    @Override
    void plexRestart() {
        new GroovyExecutor(true).execute(['killall', 'Plex Media Server', ';', 'sleep', '5', ';', 'open', '/Applications/Plex Media Server.app'])
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