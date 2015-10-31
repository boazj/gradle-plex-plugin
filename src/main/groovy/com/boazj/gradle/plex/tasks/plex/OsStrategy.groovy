package com.boazj.gradle.plex.tasks.plex

import org.apache.commons.lang.SystemUtils

abstract class OsStrategy {
    public abstract void plexStop()
    public abstract void plexStart()
    public abstract void plexRestart()
    public abstract String getPlexLogPath()
    public abstract String getChannelLogPath()
    public abstract String getPluginsPath()

    public static OsStrategy get() {
        if (SystemUtils.IS_OS_MAC) {

        } else if (SystemUtils.IS_OS_LINUX) {
            return new LinuxOsStrategy()
        } else if (SystemUtils.IS_OS_WINDOWS) {

        } else {

        }
    }
}