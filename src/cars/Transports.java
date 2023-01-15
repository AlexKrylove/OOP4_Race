package cars;

import drivers.Drivers;
import Mechanics.Mechanics;

import java.util.List;
import java.util.Objects;

public abstract class Transports implements Challenge {
    protected String brand;
    protected String model;
    protected double engineVolume;
    List<Transports> raceTransport;
    List<Mechanics> mechanics;
    List<Drivers> namesDrivers;

        public Transports(String brand, String model, double engineVolume) {
        if (brand == null || brand.isEmpty()) {
            brand = "Значение не указано";
        }
        this.brand = brand;
        if (model == null || model.isEmpty()) {
            model = "Значение не указано";
        }
        this.model = model;

        if (engineVolume <= 0) {
            engineVolume = 1.5;
        }
        this.engineVolume = engineVolume;


    }


    public static final String PIT_STOP = " делает остановку";
    public static final String BEST_LAP_TIME = "Лучшее время круга ";
    public static final String MAX_SPEED = "Максимальная скорость ";
    public static final String[] ALL_CHALLENGERS = {PIT_STOP, BEST_LAP_TIME, MAX_SPEED};

    public abstract void printType();

    public abstract void service();

    @Override

    public void pitStop() {
        System.out.println(getBrand() + " " + getModel() + PIT_STOP);
    }

    @Override
    public void bestLapTime(double time) {
        System.out.println(BEST_LAP_TIME + getBrand() + " " + getModel() + " составило " + time + " мин.");
    }

    @Override
    public void maxSpeed(double speed) {
        System.out.println(MAX_SPEED + getBrand() + " " + getModel() + " составила " + speed + " км/час");
    }

    public void getStart() {
        System.out.println(getBrand() + " " + getModel() + " начинает движение");
    }

    public void getFinish() {
        System.out.println(getBrand() + " " + getModel() + " заканчивает движение");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }
    public List<Transports> getRaceTransport() {
        return raceTransport;
    }
    public List<Mechanics> getMechanics() {
        return mechanics;
    }
    public List<Drivers> getNamesDrivers() {
        return namesDrivers;
    }


    @Override
    public String toString() {
        return "Марка: " + brand +
                ", модель: " + model +
                ", объем двигателя: " + engineVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transports that = (Transports) o;
        return Double.compare(that.engineVolume, engineVolume) == 0 && Objects.equals(brand, that.brand) && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume);
    }

}




