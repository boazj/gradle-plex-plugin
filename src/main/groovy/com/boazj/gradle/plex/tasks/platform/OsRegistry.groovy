package com.boazj.gradle.plex.tasks.platform

import org.apache.commons.lang.SystemUtils
import org.gradle.api.tasks.StopExecutionException

@Singleton
class OsRegistry {
    public static final String MAC = 'mac'
    public static final String LINUX = 'linux'
    public static final String WINDOWS = 'windows'
    private OsStrategy override = null;
    private Map<String, Class> registry = [(LINUX)  : LinuxOsStrategy,
                                           (MAC)    : MacOsStrategy,
                                           (WINDOWS): WindowsOsStrategy]
    Closure<String> getPlatform = {
        if (SystemUtils.IS_OS_MAC) {
            return MAC
        }
        if (SystemUtils.IS_OS_LINUX) {
            return LINUX
        }
        if (SystemUtils.IS_OS_WINDOWS) {
            return WINDOWS
        }
    }

    public OsStrategy get() {
        if (override != null) {
            return override
        }
        Class<? extends OsStrategy> strategy = registry[getPlatform()]
        if (strategy != null) {
            return strategy.newInstance()
        }
        throw StopExecutionException('Unsupported OS, please use the override feature.')
    }

    public OsStrategy getOverride() {
        return override
    }

    public void setOverride(OsStrategy override) {
        this.override = override
    }

}
