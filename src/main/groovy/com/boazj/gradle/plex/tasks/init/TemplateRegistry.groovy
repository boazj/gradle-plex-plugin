package com.boazj.gradle.plex.tasks.init

@Singleton
class TemplateRegistry {

    private Map<String, Template> templates = [
            (AgentProjectInitTemplate.AGENT)    : (new AgentProjectInitTemplate()),
            (ChannelProjectInitTemplate.CHANNEL): (new ChannelProjectInitTemplate()),
            (ScannerProjectInitTemplate.SCANNER): (new ScannerProjectInitTemplate()),
            (ServiceProjectInitTemplate.SERVICE): (new ServiceProjectInitTemplate())
    ]

    Template get(String id) {
        return templates.get(id)
    }

    Set<String> getSupportedTypes() {
        return templates.keySet()
    }

    boolean supports(String id) {
        return templates.containsKey(id)
    }
}
