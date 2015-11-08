package com.boazj.gradle.plex.utils

class GroovyExecutor implements ShellExecutor{

    public static String NL = System.getProperty("line.separator")

    private boolean printOut
    private boolean executed = false

    private String resultText
    private String resultStdOut
    private String resultStdErr
    private int resultValue

    public GroovyExecutor(boolean printOut = false) {
        this.printOut = printOut
    }

    public ShellExecutor execute(List<String> commands) throws IOException {
        return execute(commands, null, null)
    }

    public ShellExecutor execute(List<String> commands, List<String> environment, File dir) throws IOException {
        if (executed){
            return
        }
        executed = true
        Process process = commands.execute(environment, dir)
        def out = new StringBuilder()
        def err = new StringBuilder()

        if(printOut) {
            process.in.eachLine { line ->
                out <<= line
                println line
            }

            process.err.eachLine { line ->
                err <<= line
                println line
            }
        }

        process.waitFor()
        resultText = printOut ? (out + NL + err).toString() : process.getText()
        resultStdOut = printOut ? out.toString() : resultText
        resultStdErr = printOut ? err.toString() : ''
        resultValue = process.exitValue()
        return this
    }

    public int getResultValue() {
        return resultValue
    }

    public String getResultText() {
        return resultText
    }

    String getResultStdErr() {
        return resultStdErr
    }

    String getResultStdOut() {
        return resultStdOut
    }

    boolean getPrintOut() {
        return printOut
    }
}
