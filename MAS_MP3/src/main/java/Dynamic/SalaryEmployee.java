package Dynamic;

public class SalaryEmployee extends Employee {
    private double bonusPercentage;
    private double performanceScore;

    public SalaryEmployee(String name, double hourlyRate, double hoursWorked, double bonusPercentage, double performanceScore) {
        super(name, hourlyRate, hoursWorked);
        setBonusPercentage(bonusPercentage);
        setPerformanceScore(performanceScore);
    }

    public double getBonusPercentage() {
        return bonusPercentage;
    }

    public void setBonusPercentage(double bonusPercentage) {
        if (bonusPercentage < 0)
            throw new IllegalArgumentException("Bonus percentage cannot be negative");

        this.bonusPercentage = bonusPercentage;
    }

    public double getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(double performanceScore) {
        if (performanceScore < 0)
            throw new IllegalArgumentException("Performance score cannot be negative");

        this.performanceScore = performanceScore;
    }

    @Override
    public double calculateSalary() {
        double baseSalary = super.calculateSalary();
        double bonus = baseSalary * (bonusPercentage / 100);
        return baseSalary + bonus;
    }
}
