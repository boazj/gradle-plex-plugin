package com.boazj.gradle.plex.tasks

import com.boazj.gradle.plex.tasks.plex.OsStrategy
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class StartPlexServerTask extends DefaultTask {

    @TaskAction
    void startPlexServer(){
        OsStrategy.get().plexStart()
    }

}