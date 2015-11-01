package com.boazj.gradle.plex.utils


@Singleton
class ExecutorsFactory implements Executors {
    ShellExecutor get(boolean printOut = false){
        return new GroovyExecutor(printOut)
    }
}
