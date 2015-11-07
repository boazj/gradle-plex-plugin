package com.boazj.gradle.plex.tasks

import org.gradle.api.tasks.Copy

class BundleTask extends Copy {

    BundleTask() {
        includeEmptyDirs = true
        from(project.projectDir)
        exclude("${project.buildDir}", 'build', '*.gradle', 'gradle.properties', '.*', 'gradle', 'gradlew*', '*.iml')
        into("${project.buildDir}/bundle/${project.name}.bundle/")
    }

}
