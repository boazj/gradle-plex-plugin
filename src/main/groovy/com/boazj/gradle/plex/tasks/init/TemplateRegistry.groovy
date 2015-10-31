package com.boazj.gradle.plex.tasks.init

class TemplateRegistry {

    private static Map<String, Template> templates = [
            (AgentProjectInitTemplate.AGENT) : (new AgentProjectInitTemplate()),
            (ChannelProjectInitTemplate.CHANNEL) : (new ChannelProjectInitTemplate()),
            (ScannerProjectInitTemplate.SCANNER) : (new ScannerProjectInitTemplate()),
            (ServiceProjectInitTemplate.SERVICE) : (new ServiceProjectInitTemplate())
    ]

    static Template get(String id) {
        return templates.get(id)
    }

    static Set<String> getSupportedTypes(){
        return templates.keySet()
    }

    static boolean supports(String id){
        return templates.containsKey(id)
    }
}
