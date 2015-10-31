package com.boazj.gradle.plex.tasks.init

@Singleton
class TemplateRegistry {
    public static final String AGENT = 'agent'
    public static final String CHANNEL = 'channel'
    public static final String SCANNER = 'scanner'
    public static final String SERVICE = 'service'

    private Map<String, Template> templates = [
            AGENT, new AgentProjectInitTemplate(),
            CHANNEL, new ChannelProjectInitTemplate(),
            SCANNER, new ScannerProjectInitTemplate(),
            SERVICE, new ServiceProjectInitTemplate()
    ]

    Template get(String id) {
        return templates.get(id)
    }

    Set<String> getSupportedTypes(){
        return templates.keySet()
    }

    boolean supports(String id){
        return templates.containsKey(id)
    }
}
