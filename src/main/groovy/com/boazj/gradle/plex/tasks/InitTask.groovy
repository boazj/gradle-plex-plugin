package com.boazj.gradle.plex.tasks

import com.boazj.gradle.plex.tasks.init.TemplateRegistry
import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.internal.tasks.options.Option
import org.gradle.api.internal.tasks.options.OptionValues
import org.gradle.api.tasks.TaskAction

class InitTask extends DefaultTask {
    private String type = TemplateRegistry.CHANNEL

    @TaskAction
    void applyLayout() {
        def type = getType()
        if (!TemplateRegistry.supports(type)) {
            throw new GradleException("The requested build setup type '${type}' is not supported. Supported types: ${TemplateRegistry.supportedTypes.collect{"'$it'"}.sort().join(", ")}.")
        }
        TemplateRegistry.get(type).generate()
    }

    public String getType() {
        return type
    }

    @Option(option = "type", description = "Set type of build to create.")
    public void setType(String type) {
        this.type = type;
    }

    @OptionValues("type")
    List<String> getAvailableBuildTypes(){
        return TemplateRegistry.supportedTypes
    }
}
