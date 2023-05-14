package Dynamic;

public class HourlyEmployee extends Employee {

    private double hourlyRate;
    private double hoursWorked;
    private double overtimeRates;
    private double overtimeHours;

    public HourlyEmployee(String name, double hourlyRate, double hoursWorked, double overtimeRates, double overtimeHours) {
        super(name);
        setHourlyRate(hourlyRate);
        setHoursWorked(hoursWorked);
        setOvertimeRates(overtimeRates);
        setOvertimeHours(overtimeHours);
    }

    public HourlyEmployee(Employee employee, double hourlyRate, double hoursWorked, double overtimeRates, double overtimeHours) {
        super(employee.getName());
        setHourlyRate(hourlyRate);
        setHoursWorked(hoursWorked);
        setOvertimeRates(overtimeRates);
        setOvertimeHours(overtimeHours);
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate < 0) throw new IllegalArgumentException("Hourly Rate Cannot be less than 0");
        this.hourlyRate = hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked < 0) throw new IllegalArgumentException("Hours Worked Cannot be less than 0");
        this.hoursWorked = hoursWorked;
    }

    public double getOvertimeRates() {
        return overtimeRates;
    }

    public void setOvertimeRates(double overtimeRates) {
        if (overtimeRates < 0) throw new IllegalArgumentException("Overtime Rate Cannot be less than 0");
        this.overtimeRates = overtimeRates;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(double overtimeHours) {
        if (overtimeHours < 0) throw new IllegalArgumentException("Overtime Hours Cannot be less than 0");
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double calculateSalary() {
        double baseSalary = hoursWorked * hourlyRate;
        double overtimeSalary = overtimeRates * overtimeHours;
        return baseSalary + overtimeSalary;
    }
}
