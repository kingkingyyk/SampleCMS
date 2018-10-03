package model.SubjectEnrollment;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Month")
public class Month {
    private int id;
    private String month;
    private String year;

    private Set<MonthlyTSFee> monthlyTSFees = new HashSet<MonthlyTSFee>();

    public Month() {}

    public Month(int id, String month, String year) {
        this.id = id;
        this.month = month;
        this.year = year;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="MONTH_ID")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name="MONTH")
    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }

    @Column(name="YEAR")
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }

    @OneToMany(mappedBy = "month", cascade=CascadeType.ALL)
    public Set<MonthlyTSFee> getMonthlyTSFees() {
        return monthlyTSFees;
    }
    public void setMonthlyTSFees(Set<MonthlyTSFee> monthlyTSFees) {
        this.monthlyTSFees = monthlyTSFees;
    }
    public void addMonthlyTSFee(MonthlyTSFee monthlyTSFee)
    {
        this.monthlyTSFees.add(monthlyTSFee);
    }
}
