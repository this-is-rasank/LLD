package DesignPatterns.Behavioural.ChainResponsibilityPattern;

public class DebugLogProcessor extends LogProcessor {
    public DebugLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int logType, String message) {
        if (logType == DEBUG) {
            System.out.println(message + this.getClass());
        } else {
            super.log(logType, message);
        }
    }
}
