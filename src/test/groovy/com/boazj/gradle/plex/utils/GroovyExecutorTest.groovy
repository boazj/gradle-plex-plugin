package com.boazj.gradle.plex.utils

import org.junit.Assert
import org.junit.Test

import java.nio.charset.StandardCharsets

class GroovyExecutorTest {

    @Test
    void testExecute() {
        GroovyExecutor exe = new GroovyExecutor()
        Assert.assertFalse(exe.getPrintOut())
        List<String> commands = new ArrayList<String>()

        Process proc = [exitValue: { 0 },
                        waitFor  : { 0 }] as Process
        proc.metaClass.getText = { 'abc' }
        commands.metaClass.execute = { x, y -> return proc }


        exe.execute(commands)
        Assert.assertEquals('abc', exe.getResultText())
        Assert.assertEquals('abc', exe.getResultStdOut())
        Assert.assertEquals('', exe.getResultStdErr())
        Assert.assertEquals(0, exe.getResultValue())
    }

    @Test
    void testExecute1() {
        GroovyExecutor exe = new GroovyExecutor(true)
        List<String> commands = new ArrayList<String>()

        Process proc = [exitValue: { 0 },
                        waitFor  : { 0 }] as Process
        proc.metaClass.getIn = { new ByteArrayInputStream('in'.getBytes(StandardCharsets.UTF_8)); }
        proc.metaClass.getErr = { new ByteArrayInputStream('err'.getBytes(StandardCharsets.UTF_8)); }
        commands.metaClass.execute = { x, y -> return proc }


        exe.execute(commands)
        Assert.assertEquals('''in
                               |err'''.stripMargin(), exe.getResultText())
        Assert.assertEquals('in', exe.getResultStdOut())
        Assert.assertEquals('err', exe.getResultStdErr())
        Assert.assertEquals(0, exe.getResultValue())
    }

}
