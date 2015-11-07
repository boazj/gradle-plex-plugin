package com.boazj.gradle.plex.tasks

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder

class DistributeTaskTest {
    @Rule
    public final TemporaryFolder testProjectDir = new TemporaryFolder()

    @Test
    void testTask() {
        File dir = testProjectDir.newFolder()
        Project project = ProjectBuilder.builder().withName('test').withProjectDir(dir).build()
        BundleTask bundleTask = project.task('bundle', type: BundleTask)
        DistributeTask distributeTask = project.task('dist', type: DistributeTask)
        bundleTask.exclude('userHome')
        File bundledFile = new File(dir, 'test.test')
        bundledFile << 'test text'
        bundleTask.execute()
        distributeTask.execute()
        File buildDir = dir.listFiles().find { it.name.equals('build') }
        Assert.assertNotNull(buildDir)
        File distDir = buildDir.listFiles().find { it.name.equals('libs') }
        Assert.assertNotNull(distDir)
        Assert.assertNotNull(distDir.listFiles().find { it.name.equals('test.bundle') })
    }
}
