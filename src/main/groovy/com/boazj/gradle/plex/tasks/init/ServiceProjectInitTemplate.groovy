package com.boazj.gradle.plex.tasks.init

class ServiceProjectInitTemplate extends Template {
    public static final String SERVICE = 'service'

    @Override
    boolean supports(String id) {
        return SERVICE == id
    }

    void generate(){
        mkdirs( "Contents/Service Sets",
                "Contents/Resources")
    }
}
