package com.boazj.gradle.plex.tasks

import com.boazj.gradle.plex.tasks.platform.OsStrategy
import org.gradle.api.tasks.Copy

class PublishTask extends Copy {

    @Override
    protected void copy() {
        from("${project.buildDir}/bundle/${project.name}.bundle")
        into(OsStrategy.get().getPluginsPath())
        super.copy()
    }
}