package com.boazj.gradle.plex.tasks.init

class ScannerProjectInitTemplate implements Template {

    @Override
    boolean supports(String id) {
        return Template.SCANNER == id
    }

    void generate(){
        String s = File.separator
        new File("Contents${s}Resources").mkdirs()
    }
}