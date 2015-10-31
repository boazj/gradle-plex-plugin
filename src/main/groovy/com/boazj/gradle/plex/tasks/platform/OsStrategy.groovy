package com.boazj.gradle.plex.tasks.platform

import org.apache.commons.lang.SystemUtils
import org.gradle.api.tasks.StopExecutionException

abstract class OsStrategy {

    private static OsStrategy override = null;

    public abstract void plexStop()
    public abstract void plexStart()
    public abstract void plexRestart()
    public abstract String getPlexLogPath()
    public abstract String getChannelLogPath()
    public abstract String getPluginsPath()

    public static OsStrategy get() {
        if (override != null){
           return override
        }
        if (SystemUtils.IS_OS_MAC) {

        }
        if (SystemUtils.IS_OS_LINUX) {
            return new LinuxOsStrategy()
        }
        if (SystemUtils.IS_OS_WINDOWS) {

        }
        throw StopExecutionException('Unsupported OS, please use the override feature.')
    }

    public static OsStrategy getOverride() {
        return override
    }

    public static void setOverride(OsStrategy override) {
        OsStrategy.override = override
    }
}