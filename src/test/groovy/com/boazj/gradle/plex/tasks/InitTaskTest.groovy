package com.boazj.gradle.plex.tasks

import com.boazj.gradle.plex.tasks.init.*
import org.gradle.api.GradleException
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertTrue

class InitTaskTest {
    @Rule
    public final TemporaryFolder testProjectDir = new TemporaryFolder()
    private File testDir

    @Before
    void setup() {
        testDir = testProjectDir.newFolder()
        def registry = TemplateRegistry.instance
        registry.supportedTypes.each { type -> registry.get(type).setParent(testDir) }
    }

    @Test
    void testApplyLayout() {
        Project project = ProjectBuilder.builder().build()
        InitTask task = project.task('init', type: InitTask)
        assertEquals(ChannelProjectInitTemplate.CHANNEL, task.getType())
        task.execute()
        File[] subdirs = testDir.listFiles()
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

    @Test
    void testApplyLayoutNotDefaultType() {
        Project project = ProjectBuilder.builder().build()
        InitTask task = project.task('init', type: InitTask)
        task.setType(AgentProjectInitTemplate.AGENT)
        task.execute()
        File[] subdirs = testDir.listFiles()
        assertEquals(1, subdirs.length)
        File contents = subdirs[0]
        assertEquals('Contents', contents.getName())
        File[] subContents = contents.listFiles()
        assertEquals(2, subContents.length)
        subContents = subContents.sort { x, y -> x.getName() <=> y.getName() }
        assertEquals('Code', subContents[0].getName())
        assertEquals('Resources', subContents[1].getName())
    }

    @Test(expected = GradleException)
    void testApplyLayoutNotSupportedType() {
        Project project = ProjectBuilder.builder().build()
        InitTask task = project.task('init', type: InitTask)
        task.setType('fake')
        task.execute()
    }

    @Test
    void testGetAvailableBuildTypes() {
        Project project = ProjectBuilder.builder().build()
        InitTask task = project.task('init', type: InitTask)
        def availableTypes = task.getAvailableBuildTypes()
        def types = [(AgentProjectInitTemplate.AGENT),
                     (ChannelProjectInitTemplate.CHANNEL),
                     (ScannerProjectInitTemplate.SCANNER),
                     (ServiceProjectInitTemplate.SERVICE)]
        assertEquals(types.size(), availableTypes.size())
        assertTrue(availableTypes.containsAll(types))
    }
}
