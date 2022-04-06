package entities;

import annotattions.FrontDisplay;
import annotattions.InputType;
import annotattions.SetterOptions;
import jakarta.persistence.*;
import utils.ParseType;

import java.sql.Date;
import java.util.List;

@Entity
public class Discount implements IEntity {

    private static final int minValue = 10;
    private static final int maxValue = 90;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "duration_in_days", nullable = false)
    private int durationInDays;

    @Column(name = "promocode", unique = true, nullable = false, length = 50)
    private String promocode;

    @Column(name = "percent_value", nullable = false)
    private Integer percentValue;

    @Column(name = "name", unique = true, nullable = false, length = 50)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "discount")
    private List<Price> prices;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @FrontDisplay(name = "Name",
            inputType = InputType.Text,
            orderPlace = 2,
            dataType = String.class)
    public String getName() {
        return name;
    }

    @SetterOptions(name = "Name", parseType = ParseType.String)
    public void setName(String name) {
        this.name = name;
    }

    @FrontDisplay(name = "Percent value",
            inputType = InputType.Number,
            orderPlace = 3,
            dataType = String.class,
            min = minValue, max = maxValue)
    public Integer getPercentValue() {
        return percentValue;
    }

    @SetterOptions(name = "Percent value", parseType = ParseType.Integer)
    public void setPercentValue(Integer percentValue) {
        if(percentValue == null || !(minValue <= percentValue && percentValue <= maxValue)){
            throw new IllegalArgumentException("Please, enter a discount value from "+minValue+" to "+maxValue);
        }

        this.percentValue = percentValue;
    }

    @FrontDisplay(name = "Promocode",
            inputType = InputType.Text,
            orderPlace = 4,
            dataType = String.class)
    public String getPromocode() {
        return promocode;
    }

    @SetterOptions(name = "Promocode", parseType = ParseType.String)
    public void setPromocode(String promocode) {
        this.promocode = promocode;
    }

    @FrontDisplay(name = "Start date",
            inputType = InputType.Date,
            orderPlace = 5,
            dataType = Date.class)
    public Date getStartDate() {
        return startDate;
    }

    @SetterOptions(name = "Start date", parseType = ParseType.SqlDate)
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @FrontDisplay(name = "Duration in days",
            inputType = InputType.Text,
            orderPlace = 6,
            dataType = Integer.class)
    public int getDurationInDays() {
        return durationInDays;
    }

    @SetterOptions(name = "Duration in days", parseType = ParseType.Integer)
    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    @Override
    public String getDescription() {
        return getName();
    }
}
