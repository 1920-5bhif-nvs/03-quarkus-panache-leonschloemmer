package at.leonschloemmer.business;

import at.leonschloemmer.model.Car;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class CarRepository {

    @Inject
    EntityManager em;

    public CarRepository() {
    }

    public Car addCar(Car car) {
        throw new UnsupportedOperationException();
    }

    public Car getCarById(int id) {
        throw new UnsupportedOperationException();
    }

    public List<Car> getAllCars() {
        throw new UnsupportedOperationException();
    }
}
