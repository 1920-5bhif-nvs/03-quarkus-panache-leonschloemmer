package at.leonschloemmer;

import at.leonschloemmer.business.RentalRepository;
import at.leonschloemmer.model.Car;
import at.leonschloemmer.model.Customer;
import at.leonschloemmer.model.Rental;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
@QuarkusTest
class RentalRepositoryTest {

    @Inject
    EntityManager em;

    @Inject
    RentalRepository rentalRepository;

    int carId;
    int customerId;

    @BeforeEach
    public void clearRentalRepository() {
//        rentalRepository.
        em.createQuery("DELETE FROM Rental r").executeUpdate();

        Rental test = new Rental();
        test.setRentalStart(LocalDateTime.of(2019, 11, 5, 14, 0));
        test.setRentalStart(LocalDateTime.of(2019, 11, 5, 15, 0));

        em.persist(test);
    }

    @BeforeAll
    public  void insertCarAndCustomer() {
        Car car = new Car();
        car.setHorsepower(500);
        car.setName("Lamborghini Gallardo");

        Customer customer = new Customer();
        customer.setName("Leon Schloemmer");

        em.persist(car);
        em.persist(customer);

        carId = Math.toIntExact(car.getId());
        customerId = Math.toIntExact(customer.getId());
    }

    @Test
    public void test01_rentCarFreeDate() {
        Rental newRental = rentalRepository.addRental(carId,
                customerId,
                LocalDateTime.of(2019, 11, 5, 10, 0),
                LocalDateTime.of(2019, 11, 5, 11, 0));

        assertThat(newRental).isNotNull();
    }

    @Test
    public void test02_rentCarOverlappingStart() {
//        assertThrows()
        assertThatThrownBy(() -> {
            Rental newRental = rentalRepository.addRental(carId,
                    customerId,
                    LocalDateTime.of(2019, 11, 5, 13, 0),
                    LocalDateTime.of(2019, 11, 5, 14, 30));
        })

//        assertThat(newRental).isNull();
    }

}
