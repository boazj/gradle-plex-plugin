package com.boazj.gradle.plex.tasks.init

import org.junit.Rule;
import org.junit.Test
import org.junit.rules.TemporaryFolder;

import static org.junit.Assert.*;

class ChannelProjectInitTemplateTest {
    @Rule
    public final TemporaryFolder testProjectDir = new TemporaryFolder()

    @Test
    public void testSupports() throws Exception {
        ChannelProjectInitTemplate template = new ChannelProjectInitTemplate()
        assertFalse(template.supports('some-test'))
        assertTrue(template.supports(ChannelProjectInitTemplate.CHANNEL))
    }

    @Test
    public void testGenerate() throws Exception {
        File dir = testProjectDir.newFolder('channel-test')
        ChannelProjectInitTemplate template = new ChannelProjectInitTemplate()
        template.setParent(dir)
        template.generate()

        File[] subdirs = dir.listFiles()
        assertEquals(1, subdirs.length)
        File contents = subdirs[0]
        assertEquals('Contents', contents.getName())
        File[] subContents = contents.listFiles()
        assertEquals(5, subContents.length)
        subContents = subContents.sort { x, y -> x.getName() <=> y.getName() }
        assertEquals('Code', subContents[0].getName())
        assertEquals('Libraries', subContents[1].getName())
        File libs = subContents[1]
        File[] subLibs = libs.listFiles()
        assertEquals(1, subLibs.length)
        assertEquals('Shared', subLibs[0].getName())
        assertEquals('Resources', subContents[2].getName())
        assertEquals('Services', subContents[3].getName())
        File services = subContents[3]
        File[] subServices = services.listFiles()
        assertEquals(1, subServices.length)
        assertEquals('URL', subServices[0].getName())
        assertEquals('Strings', subContents[4].getName())
    }
}
