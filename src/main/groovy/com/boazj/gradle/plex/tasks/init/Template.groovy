package com.boazj.gradle.plex.tasks.init

abstract class Template {
    private File parent;

    abstract boolean supports(String id)

    abstract void generate()

    void mkdirs(String... paths) {
        File parent = this.parent
        paths.each {
            new File(parent, it.replaceAll('/', File.separator)).mkdirs()
        }
    }

    public void setParent(File parent) {
        this.parent = parent
    }
}