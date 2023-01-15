package Mechanics;

import cars.Transports;

import java.util.List;
import java.util.Objects;

public class Mechanics {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechanics mechanics = (Mechanics) o;
        return Objects.equals(name, mechanics.name) && Objects.equals(companyName, mechanics.companyName) && repairSpecification == mechanics.repairSpecification;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, companyName, repairSpecification);
    }

    public enum RepairSpecification {

        SPECIFICATION_CAR("ЛЕГКОВОГО ТРАНСПОРТА"),
        SPECIFICATION_TRUCK("ГРУЗОВОГО ТРАНСПОРТА"),
        SPECIFICATION_BUS("АВТОБУСОВ"),
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
    protected RepairSpecification repairSpecification;

    public Mechanics(String name, String companyName, RepairSpecification repairSpecification) {
        this.name = name;
        this.companyName = companyName;
        this.repairSpecification = repairSpecification;
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

    public RepairSpecification getRepairSpecification() {
        return repairSpecification;
    }

    @Override
    public String toString() {
        return getName() + " " + "из компании " + getCompanyName() + " специализируется на ремонте" + getRepairSpecification();
    }

}
