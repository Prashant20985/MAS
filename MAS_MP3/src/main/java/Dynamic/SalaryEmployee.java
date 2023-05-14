package Dynamic;

public class SalaryEmployee extends Employee {
    private double bonusPercentage;
    private double baseSalary;

    public SalaryEmployee(String name, double baseSalary, double bonusPercentage) {
        super(name);
        setBaseSalary(baseSalary);
        setBonusPercentage(bonusPercentage);
    }

    public SalaryEmployee(Employee employee, double baseSalary, double bonusPercentage) {
        super(employee.getName());
        setBaseSalary(baseSalary);
        setBonusPercentage(bonusPercentage);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0)
            throw new IllegalArgumentException("Base Salary cannot be negative");
        this.baseSalary = baseSalary;
    }

    public double getBonusPercentage() {
        return bonusPercentage;
    }

    public void setBonusPercentage(double bonusPercentage) {
        if (bonusPercentage < 0)
            throw new IllegalArgumentException("Bonus percentage cannot be negative");
        this.bonusPercentage = bonusPercentage;
    }

    @Override
    public double calculateSalary() {
        double bonus = baseSalary * (bonusPercentage / 100);
        return baseSalary + bonus;
    }
}
