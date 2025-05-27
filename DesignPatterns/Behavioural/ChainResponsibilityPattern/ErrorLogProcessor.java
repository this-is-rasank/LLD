package DesignPatterns.Behavioural.ChainResponsibilityPattern;

public class ErrorLogProcessor extends LogProcessor {
    public ErrorLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int logType, String message) {
        if (logType == ERROR) {
            System.out.println(message + this.getClass());
        } else {
            super.log(logType, message);
        }
    }
}