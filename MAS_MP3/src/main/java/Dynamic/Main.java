package Dynamic;

public class Main {
    public static void main(String[] args) {
        Employee employee = new HourlyEmployee("Emp 2", 30, 100, 32, 20);
        System.out.println(employee.getName() + " earned " + employee.calculateSalary() + " dollars this month.");

        employee = new SalaryEmployee(employee, 5000, 2);
        System.out.println(employee.getName() + " earned " + employee.calculateSalary() + " dollars this month.");
    }
}
