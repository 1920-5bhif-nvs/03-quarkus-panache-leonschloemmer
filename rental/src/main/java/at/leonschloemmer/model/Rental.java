package at.leonschloemmer.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Car car;
    @ManyToOne
    private Customer customer;
    private LocalDateTime rentalStart;
    private LocalDateTime rentalEnd;

    public Rental() {
    }

    public Rental(Car car, Customer customer, LocalDateTime rentalStart, LocalDateTime rentalEnd) {
        this.car = car;
        this.customer = customer;
        this.rentalStart = rentalStart;
        this.rentalEnd = rentalEnd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getRentalStart() {
        return rentalStart;
    }

    public void setRentalStart(LocalDateTime rentalStart) {
        this.rentalStart = rentalStart;
    }

    public LocalDateTime getRentalEnd() {
        return rentalEnd;
    }

    public void setRentalEnd(LocalDateTime rentalEnd) {
        this.rentalEnd = rentalEnd;
    }
}
