package unimaku.demo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
class Car {
    
    private @Id @GeneratedValue Long id;
    private String type;
    private String model;
    private int yearMade;
    private double mileage;
    private String colour;
    @Enumerated(EnumType.STRING)
    private CarStatus status;

    Car() {}

    Car(String type, String model, int yearMade, double mileage, String colour, CarStatus status) {
        this.type = type;
        this.model = model;
        this.yearMade = yearMade;
        this.mileage = mileage;
        this.colour = colour;
        this.status = status;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearMade() {
        return this.yearMade;
    }

    public void setYearMade(int yearMade) {
        this.yearMade = yearMade;
    }

    public double getMileage() {
        return this.mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getColour() {
        return this.colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public CarStatus getStatus() {
        return this.status;
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
        return true;
        if(!(o instanceof Car))
        return false;
        Car car = (Car) o;
        return 
            Objects.equals(this.id, car.id) &&
            Objects.equals(this.type, car.type) &&
            Objects.equals(this.model, car.model) &&
            Objects.equals(this.yearMade, car.yearMade) &&
            Objects.equals(this.mileage, car.mileage) &&
            Objects.equals(this.colour, car.colour) &&
            Objects.equals(this.status, car.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.type, this.model, this.yearMade, this.colour);
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + this.id + ", type='" + this.type + '\'' + ", model='" + this.model + '\'' + ", year='" + this.yearMade + '\'' + ", mileage='" + this.mileage + '\'' + ", colour='" + this.colour + '\'' + ", status='" + this.status + '\'' + '}';
    }
}
