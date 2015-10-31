package com.boazj.gradle.plex.tasks

import com.boazj.gradle.plex.tasks.platform.OsStrategy
import org.gradle.api.tasks.TaskAction

class RestartPlexServerTask extends BasePlexPlatformTask {

    @TaskAction
    void restartPlexServer(){
        OsStrategy.get().plexRestart()
    }

}

