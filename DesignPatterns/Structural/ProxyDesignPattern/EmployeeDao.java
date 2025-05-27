package DesignPatterns.Structural.ProxyDesignPattern;

public interface EmployeeDao {
    public void create(String client, EmployeeDO empl) throws Exception;

    public void delete(String client, int id) throws Exception;

    public EmployeeDO get(String client, int id) throws Exception;
}
