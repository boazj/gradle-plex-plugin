package com.boazj.gradle.plex.tasks.init

interface Template {
    boolean supports(String id)
    void generate()
}