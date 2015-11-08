package com.boazj.gradle.plex.utils

import org.junit.Assert
import org.junit.Test

class ExecutorsFactoryTest {
    @Test
    void testGet() {
        ShellExecutor exe = ExecutorsFactory.instance.get()
        Assert.assertTrue(exe instanceof GroovyExecutor)
        Assert.assertFalse(((GroovyExecutor)exe).printOut)

        ShellExecutor exePrint = ExecutorsFactory.instance.get(true)
        Assert.assertTrue(exePrint instanceof GroovyExecutor)
        Assert.assertTrue(((GroovyExecutor)exePrint).printOut)
    }
}
