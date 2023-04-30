package Dynamic;

public class Main {
    public static void main(String[] args) {
        Employee salaryEmployee = new SalaryEmployee("Emp 1", 35.0, 120, 13.0, 8.0);
        System.out.println(salaryEmployee.getName() + " earned " + salaryEmployee.calculateSalary() + " dollars this month.");

        Employee hourlyEmployee = new HourlyEmployee("Emp 2", 30, 100, 32, 20);
        System.out.println(hourlyEmployee.getName() + " earned " + hourlyEmployee.calculateSalary() + " dollars this month.");
    }
}
