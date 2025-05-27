package DesignPatterns.Structural.ProxyDesignPattern;

public class main {
    public static void main(String[] args) {
        try {
            EmployeeDO empl = new EmployeeDO();
            EmployeeDaoImplemntation impl = new EmployeeDaoImplemntation();
            EmployeeDaoProxy proxy = new EmployeeDaoProxy(impl);
            proxy.create("USER", empl);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
