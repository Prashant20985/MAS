package Multi_Inheritance;

public class Car {
    private String model;
    private int year;

    public Car(String model, int year) {
        setModel(model);
        setYear(year);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if(model == null || model.isBlank())
            throw new IllegalArgumentException("Model should not be blank or null");
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "model='" + model + '\'' +
                ", year=" + year ;
    }
}
