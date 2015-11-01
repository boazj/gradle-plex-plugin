package com.boazj.gradle.plex.tasks.platform

import com.boazj.gradle.plex.utils.Executors
import com.boazj.gradle.plex.utils.ShellExecutor
import org.junit.Test

import static org.junit.Assert.assertTrue
import static org.mockito.Mockito.*

class OsRegistryTest {

    @Test
    public void testGetLinux(){
        OsRegistry.instance.getPlatform = { return OsRegistry.LINUX }
        OsStrategy strategy = OsRegistry.instance.get()
        assertTrue(strategy instanceof LinuxOsStrategy)
        Executors mockExecutors = mock(Executors.class)
        strategy.setExecutors(mockExecutors)
        ShellExecutor mockExecutor = mock(ShellExecutor.class)
        when(mockExecutors.get(true)).thenReturn(mockExecutor)
        strategy.plexStop()
        verify(mockExecutor).execute(LinuxOsStrategy.STOP_CMD)
        strategy.plexStart()
        verify(mockExecutor).execute(LinuxOsStrategy.START_CMD)
        strategy.plexRestart()
        verify(mockExecutor).execute(LinuxOsStrategy.RESTART_CMD)
    }

    @Test
    public void testGetMac(){
        OsRegistry.instance.getPlatform = { return OsRegistry.MAC }
        OsStrategy strategy = OsRegistry.instance.get()
        assertTrue(strategy instanceof MacOsStrategy)
        Executors mockExecutors = mock(Executors.class)
        strategy.setExecutors(mockExecutors)
        ShellExecutor mockExecutor = mock(ShellExecutor.class)
        when(mockExecutors.get(true)).thenReturn(mockExecutor)
        strategy.plexStop()
        verify(mockExecutor).execute(MacOsStrategy.STOP_CMD)
        strategy.plexStart()
        verify(mockExecutor).execute(MacOsStrategy.START_CMD)
        strategy.plexRestart()
        verify(mockExecutor).execute(MacOsStrategy.RESTART_CMD)
    }
}
