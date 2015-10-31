package com.boazj.gradle.plex.tasks

import org.gradle.api.tasks.Copy

class BundleTask extends Copy {

    @Override
    protected void copy() {
        includeEmptyDirs = true
        from(project.projectDir)
        exclude('build', '*.gradle', 'gradle.properties', '.*', 'gradle', 'gradlew*', '*.iml')
        into("${project.buildDir}/bundle/${project.name}.bundle/")
        super.copy()
    }
}
