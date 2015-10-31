package com.boazj.gradle.plex.tasks.init

class ChannelProjectInitTemplate implements Template {

    @Override
    boolean supports(String id) {
        return Template.CHANNEL == id
    }

    void generate(){
        String s = File.separator
        new File("Contents${s}Code").mkdirs()
        new File("Contents${s}Resources").mkdirs()
        new File("Contents${s}Strings").mkdirs()
        new File("Contents${s}Libraries${s}Shared").mkdirs()
        new File("Contents${s}Services${s}URL").mkdirs()
    }
}
