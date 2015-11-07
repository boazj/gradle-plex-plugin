package com.boazj.gradle.plex.tasks

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder

class BundleTaskTest {
    @Rule
    public final TemporaryFolder testProjectDir = new TemporaryFolder()

    @Test
    void testBundle() {
        File dir = testProjectDir.newFolder()
        Project project = ProjectBuilder.builder().withName('test').withProjectDir(dir).build()
        project.apply(plugin: 'base')
        BundleTask task = project.task('bundle', type: BundleTask)
        task.exclude('userHome')
        File bundledFile = new File(dir, 'test.test')
        bundledFile  << 'test text'
        task.execute()
        File buildDir = dir.listFiles().find { it.name.equals('build')}
        Assert.assertNotNull(buildDir)
        Assert.assertEquals(1, buildDir.listFiles().length)
        File bundleDir = buildDir.listFiles().find { it.name.equals('bundle')}
        Assert.assertNotNull(bundleDir)
        Assert.assertEquals(1, bundleDir.listFiles().length)
        File projectDir = bundleDir.listFiles().find { it.name.equals('test.bundle')}
        Assert.assertNotNull(projectDir)
        Assert.assertEquals(1, projectDir.listFiles().length)
        File testFile = projectDir.listFiles().find { it.name.equals('test.test')}
        Assert.assertNotNull(testFile)
        Assert.assertEquals('test text', testFile.text)
    }
}
