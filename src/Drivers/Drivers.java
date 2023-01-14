package Drivers;

import cars.Challenge;
import cars.Transports;

public class Drivers<A extends Transports & Challenge> {
    protected String name;
    protected String driveLicense;
    protected int seniority;

    public Drivers(String name, String driveLicense, int seniority) {
        if (name == null || name.isEmpty()) {
            name = "Значение не указано";
        }
        this.name = name;
        setDriveLicense(driveLicense);
        if (seniority <= 0) {
            seniority = 1;
        }
        this.seniority = seniority;
    }

    public void getStart(A transport) {
        System.out.println(getName() + " начинает движение на " + transport.getBrand() + " " + transport.getModel());
    }

    public void getFinish(A transport) {
        System.out.println(getName() + " заканчивает движение на " + transport.getBrand() + " " + transport.getModel());

    }

    @Override
    public String toString() {
        return name;
    }

    public void getGasUp(A transport) {
        System.out.println(getName() + " заправляет авто " + transport.getBrand() + " " + transport.getModel());

    }

    public String getDriveLicense() {
        return driveLicense;
    }

    public void setDriveLicense(String driveLicense) {
        if (driveLicense == null || driveLicense.isEmpty() || driveLicense.isBlank()) {
            throw new IllegalArgumentException("Необходимо указать категорию прав: B,C или D");
        }
        this.driveLicense = driveLicense;
    }// В ДОМАШКЕ ОТ 28 ДЕКАБРЯ РАЗБОР, НАДО ЧЕРЕЗ БУЛИН

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
