package com.boazj.gradle.plex.tasks.init

class ChannelProjectInitTemplate extends Template {
    public static final String CHANNEL = 'channel'

    @Override
    boolean supports(String id) {
        return CHANNEL == id
    }

    void generate() {
        mkdirs( "Contents/Code",
                "Contents/Resources",
                "Contents/Strings",
                "Contents/Libraries/Shared",
                "Contents/Services/URL")
    }
}
