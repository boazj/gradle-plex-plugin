package com.boazj.gradle.plex.utils

interface ShellExecutor {
    ShellExecutor execute(List<String> commands) throws IOException
    ShellExecutor execute(List<String> commands, List<String> environment, File dir) throws IOException
    int getResultValue()
    String getResultText()
    String getResultStdOut()
    String getResultStdErr()
}
