package com.boazj.gradle.plex.tasks.platform

import com.boazj.gradle.plex.utils.Executors
import com.boazj.gradle.plex.utils.ExecutorsFactory

abstract class OsStrategy {
    private Executors executors = ExecutorsFactory.instance

    public abstract void plexStop()
    public abstract void plexStart()
    public abstract void plexRestart()
    public abstract String getPlexLogPath()
    public abstract String getChannelLogPath()
    public abstract String getPluginsPath()


    protected Executors getExecutors() {
        return executors
    }

    void setExecutors(Executors executors) {
        this.executors = executors
    }
}