package com.boazj.gradle.plex.tasks

import com.boazj.gradle.plex.tasks.platform.OsStrategy
import org.gradle.api.tasks.TaskAction

class StartPlexServerTask extends BasePlexPlatformTask {

    @TaskAction
    void startPlexServer(){
        OsStrategy.get().plexStart()
    }

}