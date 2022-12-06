package com.keyin.tournaments;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Tournament {
    @Id
    @SequenceGenerator(name = "city_sequence", sequenceName = "city_sequence", allocationSize = 1, initialValue=10)
    @GeneratedValue(generator = "city_sequence")

    private int id;
    private  String location;
    private Date startDate;
    private Date endDate;
    private int entryFee;
    private int cashPrize;

    public Tournament(){}

    public Tournament(int id, String location, Date startDate, Date endDate, int entryFee, int cashPrize){
        this.setId(id);
        this.setLocation(location);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setEntryFee(entryFee);
        this.setCashPrize(cashPrize);
    }

    @ManyToMany
    private List<Tournament> tournaments;

    public List<Tournament> getTournaments() {
        return tournaments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(int entryFee) {
        this.entryFee = entryFee;
    }

    public int getCashPrize() {
        return cashPrize;
    }

    public void setCashPrize(int cashPrize) {
        this.cashPrize = cashPrize;
    }
}
