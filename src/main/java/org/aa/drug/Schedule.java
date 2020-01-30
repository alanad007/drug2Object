package org.aa.drug;

import java.util.Objects;

public class Schedule {

    Long DrugCode;
    String schedule;
    String scheduleF;

    public Schedule() {
    }

    public Schedule(Long drugCode, String schedule, String scheduleF) {
        DrugCode = drugCode;
        this.schedule = schedule;
        this.scheduleF = scheduleF;
    }

    public Long getDrugCode() {
        return DrugCode;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "DrugCode=" + DrugCode +
                ", schedule='" + schedule + '\'' +
                ", scheduleF='" + scheduleF + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schedule)) return false;
        Schedule schedule1 = (Schedule) o;
        return Objects.equals(getDrugCode(), schedule1.getDrugCode()) &&
                Objects.equals(getSchedule(), schedule1.getSchedule()) &&
                Objects.equals(getScheduleF(), schedule1.getScheduleF());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDrugCode(), getSchedule(), getScheduleF());
    }

    public void setDrugCode(Long drugCode) {
        DrugCode = drugCode;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getScheduleF() {
        return scheduleF;
    }

    public void setScheduleF(String scheduleF) {
        this.scheduleF = scheduleF;
    }
}
