package com.boazj.gradle.plex.tasks

import org.gradle.api.tasks.bundling.Zip

class DistributeTask extends Zip {

    DistributeTask() {
        archiveName = "${project.name}.bundle"
        destinationDir = new File("${project.buildDir}/libs")
        includeEmptyDirs = true
        from("${project.buildDir}/bundle/")
    }
}
