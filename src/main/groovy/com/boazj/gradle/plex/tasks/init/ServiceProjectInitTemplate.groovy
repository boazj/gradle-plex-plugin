package com.boazj.gradle.plex.tasks.init

class ServiceProjectInitTemplate implements Template {

    @Override
    boolean supports(String id) {
        return Template.SERVICE == id
    }

    void generate(){
        String s = File.separator
        new File("Contents${s}Service Sets").mkdirs()
        new File("Contents${s}Resources").mkdirs()
    }
}
