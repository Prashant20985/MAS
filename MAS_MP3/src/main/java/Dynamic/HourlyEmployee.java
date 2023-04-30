package Dynamic;

public class HourlyEmployee extends Employee {

    private double overtimeRates;
    private double overtimeHours;

    public HourlyEmployee(String name, double hourlyRate, double hoursWorked, double overtimeRates, double overtimeHours) {
        super(name, hourlyRate, hoursWorked);
        setOvertimeHours(overtimeHours);
        setOvertimeRates(overtimeRates);
    }

    public double getOvertimeRates() {
        return overtimeRates;
    }

    public void setOvertimeRates(double overtimeRates) {
        if(overtimeRates < 0)
            throw new IllegalArgumentException("Overtime rates cannot be negative");

        this.overtimeRates = overtimeRates;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(double overtimeHours) {
        if(overtimeHours < 0)
            throw new IllegalArgumentException("Overtime hrs cannot be negative");

        this.overtimeHours = overtimeHours;
    }

    @Override
    public double calculateSalary() {
        double baseSalary = super.calculateSalary();
        double overtimePay = overtimeRates * overtimeHours;
        return baseSalary + overtimePay;
    }
}
