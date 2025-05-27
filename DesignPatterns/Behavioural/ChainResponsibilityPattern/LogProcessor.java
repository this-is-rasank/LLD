package DesignPatterns.Behavioural.ChainResponsibilityPattern;

public abstract class LogProcessor {
    static int LOG = 1;
    static int DEBUG = 2;
    static int ERROR = 3;

    LogProcessor nextLogProcessor;

    public LogProcessor(LogProcessor nextLogProcessor) {
        this.nextLogProcessor = nextLogProcessor;
    }

    public void log(int logType, String message) {
        if (this.nextLogProcessor != null) {
            this.nextLogProcessor.log(logType, message);
        }
    }
}
