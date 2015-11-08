package com.boazj.gradle.plex.tasks.init

abstract class Template {
    private File parent;

    abstract boolean supports(String id)

    abstract void generate()

    void mkdirs(String... paths) {
        File parent = this.parent
        paths.each {
            String path = it.replaceAll('/', File.separator)
            if (parent != null) {
                return new File(parent, path).mkdirs()
            }
            return new File(path).mkdirs()
        }
    }

    public void setParent(File parent) {
        this.parent = parent
    }
}