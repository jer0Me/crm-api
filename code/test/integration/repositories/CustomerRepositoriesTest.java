package integration.repositories;

import model.entities.CustomerResponse;
import model.pojos.Customer;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.Application;
import play.db.Database;
import play.db.evolutions.Evolutions;
import play.inject.guice.GuiceApplicationBuilder;
import repositories.impl.CustomerRepositoryImpl;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CustomerRepositoriesTest {

    private static final String NAME = "Jerome";
    private static final String SURNAME = "Samson";

    private CustomerRepositoryImpl customerRepository;
    private Database database;
    private CustomerResponse lastCustomerCreated;

    public CustomerRepositoriesTest() {
        Application application = new GuiceApplicationBuilder().build();
        database = application.injector().instanceOf(Database.class);
        customerRepository = new CustomerRepositoryImpl();
        DSLContext dslContext = DSL.using(this.database.getConnection());
        customerRepository.setDslContext(dslContext);
    }

    @Before
    public void setUp() {
        Evolutions.applyEvolutions(database);
        setUpFixture();
    }

    @After
    public void tearDown() {
        Evolutions.cleanupEvolutions(database);
        this.database.shutdown();
    }

    private void setUpFixture() {
        Customer customer = new Customer();
        customer.setName(NAME);
        customer.setSurname(SURNAME);
        customer.setCreatedBy(1L);
        customer.setModifiedBy(1L);
        customerRepository.addCustomer(customer);
        List<CustomerResponse> customers = customerRepository.getCustomersActive();
        lastCustomerCreated = customers.get(customers.size() - 1);
    }

    @Test
    public void shouldAddNewCustomer() {
        assertEquals("Jerome", lastCustomerCreated.getName());
        assertEquals("Samson", lastCustomerCreated.getSurname());
    }

    @Test
    public void shouldEditCustomer() {
        Customer customer = new Customer();
        customer.setName("JRM");
        customer.setSurname("SAM");
        customer.setUuid(lastCustomerCreated.getUuid());
        customer.setModifiedBy(1L);
        customerRepository.editCustomer(customer);
        CustomerResponse customerEdited =
                customerRepository.getCustomerByUuid(lastCustomerCreated.getUuid()).get();
        assertEquals("JRM", customerEdited.getName());
        assertEquals("SAM", customerEdited.getSurname());
    }

    @Test
    public void shouldEditCustomerPhotoName() {
        String photoUrl = "myphotourl";
        Customer customer = new Customer();
        customer.setUuid(lastCustomerCreated.getUuid());
        customer.setPhotoUrl(photoUrl);
        customerRepository.updateCustomerPhotoName(customer);
        CustomerResponse customerEdited = customerRepository
                .getCustomerByUuid(lastCustomerCreated.getUuid()).get();
        assertEquals(photoUrl, customerEdited.getPhotoUrl());
    }

    @Test
    public void shouldDeleteCustomer() {
        customerRepository.deleteCustomer(lastCustomerCreated.getUuid());
        List<CustomerResponse> customers = customerRepository.getCustomersActive();
        assertEquals(0, customers.size());
    }

}
