package com.boazj.gradle.plex.tasks.init

class AgentProjectInitTemplate implements Template {

    @Override
    boolean supports(String id) {
        return Template.AGENT == id
    }

    void generate(){
        String s = File.separator
        new File("Contents${s}Code").mkdirs()
        new File("Contents${s}Resources").mkdirs()
    }
}
