package DesignPatterns.Structural.ProxyDesignPattern;

public class EmployeeDaoProxy implements EmployeeDao {
    EmployeeDao DaoObj;

    public EmployeeDaoProxy(EmployeeDaoImplemntation impl) {
        this.DaoObj = impl;
    }

    @Override
    public void create(String client, EmployeeDO empl) throws Exception {
        if (client == "ADMIN") {
            DaoObj.create(client, empl);
            return;
        }
        throw new Exception("Access Denied.");
    }

    @Override
    public void delete(String client, int id) throws Exception {
        if (client == "ADMIN") {
            DaoObj.delete(client, id);
            return;
        }
        throw new Exception("Access Denied.");
    }

    @Override
    public EmployeeDO get(String client, int id) throws Exception {
        if (client == "ADMIN" || client == "USER") {
            return DaoObj.get(client, id);
        }
        throw new Exception("Access Denied.");
    }

}
