package com.boazj.gradle.plex.tasks.init

import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder

import static org.junit.Assert.*

public class ServiceProjectInitTemplateTest {
    @Rule
    public final TemporaryFolder testProjectDir = new TemporaryFolder()

    @Test
    public void testSupports() throws Exception {
        ServiceProjectInitTemplate template = new ServiceProjectInitTemplate()
        assertFalse(template.supports('some-test'))
        assertTrue(template.supports(ServiceProjectInitTemplate.SERVICE))
    }

    @Test
    public void testGenerate() throws Exception {
        File dir = testProjectDir.newFolder('service-test')
        ServiceProjectInitTemplate template = new ServiceProjectInitTemplate()
        template.setParent(dir)
        template.generate()

        File[] subdirs = dir.listFiles()
        assertEquals(1, subdirs.length)
        File contents = subdirs[0]
        assertEquals('Contents', contents.getName())
        File[] subContents = contents.listFiles()
        assertEquals(2, subContents.length)
        subContents = subContents.sort { x, y -> x.getName() <=> y.getName() }
        assertEquals('Resources', subContents[0].getName())
        assertEquals('Service Sets', subContents[1].getName())
    }
}