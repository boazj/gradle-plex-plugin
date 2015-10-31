package com.boazj.gradle.plex.tasks.init

class AgentProjectInitTemplate extends Template {
    public static final String AGENT = 'agent'

    @Override
    boolean supports(String id) {
        return AGENT == id
    }

    void generate(){
        mkdirs( "Contents/Code",
                "Contents/Resources")
    }
}
