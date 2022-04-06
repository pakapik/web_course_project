package entities;

import annotattions.FrontDisplay;
import annotattions.InputType;
import annotattions.SetterOptions;
import jakarta.persistence.*;
import utils.ParseType;

@Entity
public class Price implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @ManyToOne
    @JoinColumn(name = "discount")
    private Discount discount;

    @ManyToOne
    @JoinColumn(name = "course", nullable = false)
    private Course course;

    @Column(name = "sum_without_discount", nullable = false)
    private int sumWithoutDiscount;

    @Column(name = "Name", unique = true, nullable = false)
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @FrontDisplay(name = "Course",
            inputType = InputType.SelectEntity,
            orderPlace = 1,
            dataType = Course.class)
    public Course getCourse() {
        return course;
    }

    @SetterOptions(name = "Course", parseType = ParseType.Entity)
    public void setCourse(Course course) {
        this.course = course;
    }

    @FrontDisplay(name = "Discount",
            inputType = InputType.SelectEntity,
            orderPlace = 2,
            dataType = Discount.class,
            isRequired = false)
    public Discount getDiscount() {
        return discount;
    }

    @SetterOptions(name = "Discount", parseType = ParseType.Entity)
    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    @FrontDisplay(name = "Name",
            inputType = InputType.Text,
            orderPlace = 3,
            dataType = String.class)
    public String getName() {
        return name;
    }

    @SetterOptions(name = "Name", parseType = ParseType.String)
    public void setName(String name) {
        this.name = name;
    }

    @FrontDisplay(name = "Sum without discount",
            inputType = InputType.Number,
            orderPlace = 4,
            dataType = Integer.class,
            max = Integer.MAX_VALUE)
    public int getSumWithoutDiscount() {
        return sumWithoutDiscount;
    }

    @SetterOptions(name = "Sum without discount", parseType = ParseType.Integer)
    public void setSumWithoutDiscount(int sumWithoutDiscount) {
        if(sumWithoutDiscount < 0) {
            throw new IllegalArgumentException("The price cannot be negative");
        }

        this.sumWithoutDiscount = sumWithoutDiscount;
    }

    @Override
    public String getDescription() {
        return getName();
    }
}
