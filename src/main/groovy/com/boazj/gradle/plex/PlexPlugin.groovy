package com.boazj.gradle.plex

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.PluginInstantiationException

class PlexPlugin implements Plugin<Project> {
    public static final String INIT_TASK_NAME = 'initPlex'

    @Override
    void apply(Project project) {
        def potentialHijackedTask = project.tasks.findByName(INIT_TASK_NAME)

        if (potentialHijackedTask != null) {
            throw new PluginInstantiationException("Cannot instantiate plugin plex due to hijacked task name (${INIT_TASK_NAME})")
        }

        project.tasks.create(INIT_TASK_NAME, TailLogTask.class)
    }

}
