package at.leonschloemmer.business;

import at.leonschloemmer.model.Rental;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class RentalRepository {

    @Inject
    EntityManager em;

    public RentalRepository() {
    }

    public Rental addRental(int carId, int customerId, LocalDateTime from, LocalDateTime to) {
//        em.
        throw new UnsupportedOperationException();
    }

    public List<Rental> getRentalsForCar(int carId) {
        throw new UnsupportedOperationException();
    }

    public List<Rental> getRentalsForCustomer(int customerId) {
        throw new UnsupportedOperationException();
    }

    public List<Rental> getRentalsForCarInTimespan(int carId, LocalDateTime from, LocalDateTime to) {
        throw new UnsupportedOperationException();
    }

}
