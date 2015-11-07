package com.boazj.gradle.plex.tasks.init

import org.junit.Test

import static org.junit.Assert.*

class TemplateRegistryTest {

    @Test
    void testGet() {
        assertTrue(TemplateRegistry.instance.get(AgentProjectInitTemplate.AGENT) instanceof AgentProjectInitTemplate)
        assertTrue(TemplateRegistry.instance.get(ChannelProjectInitTemplate.CHANNEL) instanceof ChannelProjectInitTemplate)
        assertTrue(TemplateRegistry.instance.get(ScannerProjectInitTemplate.SCANNER) instanceof ScannerProjectInitTemplate)
        assertTrue(TemplateRegistry.instance.get(ServiceProjectInitTemplate.SERVICE) instanceof ServiceProjectInitTemplate)
        assertEquals(null, TemplateRegistry.instance.get('fake'))
    }

    @Test
    void testGetSupportedTypes() {
        Set<String> supportedTypes = TemplateRegistry.instance.getSupportedTypes()
        assertEquals(4, supportedTypes.size())
        assertTrue(supportedTypes.contains(AgentProjectInitTemplate.AGENT))
        assertTrue(supportedTypes.contains(ChannelProjectInitTemplate.CHANNEL))
        assertTrue(supportedTypes.contains(ScannerProjectInitTemplate.SCANNER))
        assertTrue(supportedTypes.contains(ServiceProjectInitTemplate.SERVICE))
    }

    @Test
    void testSupports() {
        [AgentProjectInitTemplate.AGENT,
         ChannelProjectInitTemplate.CHANNEL,
         ScannerProjectInitTemplate.SCANNER,
         ServiceProjectInitTemplate.SERVICE].each { assertTrue(TemplateRegistry.instance.supports(it)) }
        assertFalse(TemplateRegistry.instance.supports('fake'))
    }
}
