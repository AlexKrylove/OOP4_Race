package Mechanics;

import cars.Transports;

import java.util.List;

public class Mechanics<A extends Transports> {

    public enum RepairSpecification {

        SPECIFICATION_CAR("ЛЕГКОВОГО ТРАНСПОРТА"),
        SPECIFICATION_TRUCK("ГРУЗОВОГО ТРАНСОРТА"),
        SPECIFICATION_UNIVERSAL("ВСЕХ ТИПОВ ТРАНСПОРТА");

        private final String specification;

        RepairSpecification(String specification) {
            this.specification = specification;
        }

        public String getSpecification() {
            return specification;
        }

        @Override
        public String toString() {
            return " " + getSpecification() + " ";
        }
    }

    protected String name;
    protected String companyName;
    protected static RepairSpecification RepairSpecification;

    public Mechanics(String name, String companyName, RepairSpecification RepairSpecification) {
        this.name = name;
        this.companyName = companyName;
        this.RepairSpecification = RepairSpecification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Mechanics.RepairSpecification getRepairSpecification() {
        return RepairSpecification;
    }

    public void getTO(A transport) {
        System.out.println(name + " проводит технический осмотр " + transport.getBrand() + " " + transport.getModel());
    }

    public void getFixCar(A transport) {
        System.out.println(name + " чинит транспорт " + transport.getBrand() + " " + transport.getModel());
    }

    @Override
    public String toString() {
        return getName() + " " + " из компании " + getCompanyName() + " занимается ремонтом " + getRepairSpecification();
    }

}
