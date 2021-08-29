package co.tz.infowise.gmrSystem.entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Set;


@Entity
public class Guard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "guard")
    private Set<Vehicle> vehicle;

    public Set<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(Set<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int calculateAge(LocalDate dateOfBirth) {
        // validate inputs ...
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }


    @Override
    public String toString() {
        return "Guard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", vehicle=" + vehicle +
                '}';
    }
}
