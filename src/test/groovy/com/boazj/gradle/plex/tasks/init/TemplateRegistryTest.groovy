package com.boazj.gradle.plex.tasks.init

import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertTrue;

class TemplateRegistryTest {

    @Test
    void testGet() {
        assertTrue(TemplateRegistry.get(AgentProjectInitTemplate.AGENT) instanceof AgentProjectInitTemplate)
        assertTrue(TemplateRegistry.get(ChannelProjectInitTemplate.CHANNEL) instanceof ChannelProjectInitTemplate)
        assertTrue(TemplateRegistry.get(ScannerProjectInitTemplate.SCANNER) instanceof ScannerProjectInitTemplate)
        assertTrue(TemplateRegistry.get(ServiceProjectInitTemplate.SERVICE) instanceof ServiceProjectInitTemplate)
        assertEquals(null, TemplateRegistry.get('fake'))
    }

    @Test
    void testGetSupportedTypes() {
        Set<String> supportedTypes = TemplateRegistry.getSupportedTypes()
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
         ServiceProjectInitTemplate.SERVICE].each { assertTrue(TemplateRegistry.supports(it)) }
        assertFalse(TemplateRegistry.supports('fake'))
    }
}
