package com.boazj.gradle.plex.tasks.init

class ScannerProjectInitTemplate extends Template {
    public static final String SCANNER = 'scanner'

    @Override
    boolean supports(String id) {
        return SCANNER == id
    }

    void generate(){
        mkdirs("Contents/Resources")
    }
}