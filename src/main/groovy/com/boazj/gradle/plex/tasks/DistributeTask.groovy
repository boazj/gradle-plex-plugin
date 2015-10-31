package com.boazj.gradle.plex.tasks

import org.gradle.api.tasks.bundling.Zip

class DistributeTask extends Zip {
    @Override
    protected void copy() {
        archiveName = "${project.name}.bundle"
        includeEmptyDirs = true
        from("${project.buildDir}/bundle/")
        super.copy()
    }
}
