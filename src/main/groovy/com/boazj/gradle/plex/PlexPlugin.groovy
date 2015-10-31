package com.boazj.gradle.plex

import com.boazj.gradle.plex.tasks.BundleTask
import com.boazj.gradle.plex.tasks.DistributeTask
import com.boazj.gradle.plex.tasks.InitTask
import com.boazj.gradle.plex.tasks.PublishTask
import com.boazj.gradle.plex.tasks.RestartPlexServerTask
import com.boazj.gradle.plex.tasks.StartPlexServerTask
import com.boazj.gradle.plex.tasks.StopPlexServerTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task

class PlexPlugin implements Plugin<Project> {
    public static final String INIT_TASK_NAME = 'initPlex'
    public static final String BUNDLE_TASK_NAME = 'bundle'
    public static final String DIST_TASK_NAME = 'dist'
    public static final String STOP_TASK_NAME = 'stop'
    public static final String START_TASK_NAME = 'start'
    public static final String RESTART_TASK_NAME = 'restart'
    public static final String PUBLISH_TASK_NAME = 'publish'

    @Override
    void apply(Project project) {
        if (!project.getPluginManager().hasPlugin('base')){
            project.apply(plugin: 'base')
        }

        project.tasks.create(name: INIT_TASK_NAME, type: InitTask.class)
        Task bundle = project.tasks.create(name: BUNDLE_TASK_NAME, type: BundleTask.class)
        Task dist = project.tasks.create(name: DIST_TASK_NAME, type: DistributeTask.class, dependsOn: bundle)
        project.tasks.findByName('assemble').dependsOn(bundle, dist)
        project.tasks.create(name: STOP_TASK_NAME, type: StopPlexServerTask.class)
        project.tasks.create(name: START_TASK_NAME, type: StartPlexServerTask.class)
        project.tasks.create(name: RESTART_TASK_NAME, type: RestartPlexServerTask.class)
        project.tasks.create(name: PUBLISH_TASK_NAME, type: PublishTask.class, dependsOn: 'build')
    }

}
