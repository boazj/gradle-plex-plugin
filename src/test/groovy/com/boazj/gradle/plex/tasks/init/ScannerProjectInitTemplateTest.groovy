package com.boazj.gradle.plex.tasks.init

import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder

import static org.junit.Assert.*;

class ScannerProjectInitTemplateTest{
    @Rule
    public final TemporaryFolder testProjectDir = new TemporaryFolder()

    @Test
    public void testSupports() throws Exception {
        ScannerProjectInitTemplate template = new ScannerProjectInitTemplate()
        assertFalse(template.supports('some-test'))
        assertTrue(template.supports(ScannerProjectInitTemplate.SCANNER))
    }

    @Test
    public void testGenerate() throws Exception {
        File dir = testProjectDir.newFolder('scanner-test')
        ScannerProjectInitTemplate template = new ScannerProjectInitTemplate()
        template.setParent(dir)
        template.generate()

        File[] subdirs = dir.listFiles()
        assertEquals(1, subdirs.length)
        File contents = subdirs[0]
        assertEquals('Contents', contents.getName())
        File[] subContents = contents.listFiles()
        assertEquals(1, subContents.length)
        assertEquals('Resources', subContents[0].getName())
    }
}