package at.leonschloemmer.business;

import at.leonschloemmer.model.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class CustomerRepository {

    @Inject
    EntityManager em;

    public CustomerRepository() {
    }

    public Customer addCustomer() {
        throw new UnsupportedOperationException();
    }

    public Customer getCustomerWithId() {
        throw new UnsupportedOperationException();
    }
}
