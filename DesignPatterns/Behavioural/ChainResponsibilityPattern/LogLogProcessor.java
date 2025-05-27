package DesignPatterns.Behavioural.ChainResponsibilityPattern;

public class LogLogProcessor extends LogProcessor {
    public LogLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int logType, String message) {
        if (logType == LOG) {
            System.out.println(message + this.getClass());
        } else {
            super.log(logType, message);
        }
    }
}
