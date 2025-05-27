package DesignPatterns.Structural.ProxyDesignPattern;

public class EmployeeDaoImplemntation implements EmployeeDao {
    @Override
    public void create(String client, EmployeeDO empl) throws Exception {
        System.out.println("Created EmployeeDO with id: " + empl.id);
    }

    @Override
    public void delete(String client, int id) throws Exception {
        System.out.println("Deleted EmployeeDO with id: " + id);
    }

    @Override
    public EmployeeDO get(String client, int id) throws Exception {
        return new EmployeeDO();
    }
}
