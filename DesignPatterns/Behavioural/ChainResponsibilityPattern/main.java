package DesignPatterns.Behavioural.ChainResponsibilityPattern;

public class main {
    public static void main(String[] args) {
        LogLogProcessor log = new LogLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        log.log(3, "This is a Log from class: ");
    }
}
