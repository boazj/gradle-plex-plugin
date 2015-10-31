package com.boazj.gradle.plex.tasks

import com.boazj.gradle.plex.tasks.platform.OsStrategy
import org.gradle.api.tasks.TaskAction

class StopPlexServerTask extends BasePlexPlatformTask {

    @TaskAction
    void stopPlexServer(){
        OsStrategy.get().plexStop()
    }

}
