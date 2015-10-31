package com.boazj.gradle.plex.tasks.init

import org.junit.Rule;
import org.junit.Test
import org.junit.rules.TemporaryFolder;

import static org.junit.Assert.*;

public class AgentProjectInitTemplateTest {
    @Rule
    public final TemporaryFolder testProjectDir = new TemporaryFolder()

    @Test
    public void testSupports() throws Exception {
        AgentProjectInitTemplate template = new AgentProjectInitTemplate()
        assertFalse(template.supports('some-test'))
        assertTrue(template.supports(AgentProjectInitTemplate.AGENT))
    }

    @Test
    public void testGenerate() throws Exception {
        File dir = testProjectDir.newFolder('agent-test')
        AgentProjectInitTemplate template = new AgentProjectInitTemplate()
        template.setParent(dir)
        template.generate()

        File[] subdirs = dir.listFiles()
        assertEquals(1, subdirs.length)
        File contents = subdirs[0]
        assertEquals('Contents', contents.getName())
        File[] subContents = contents.listFiles()
        assertEquals(2, subContents.length)
        subContents = subContents.sort { x, y -> x.getName() <=> y.getName() }
        assertEquals('Code', subContents[0].getName())
        assertEquals('Resources', subContents[1].getName())
    }
}