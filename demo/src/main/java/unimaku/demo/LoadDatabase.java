package unimaku.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.core.annotation.Order;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initCustomers(CustomerRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Customer("Nanny Ogg", "grannyogg@ramtops.com")));
            log.info("Preloading " + repository.save(new Customer("Granny Weatherwax", "esme@ramtops.com")));
            };
        }

    @Bean      
    CommandLineRunner initCars(CarRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Car("Citroen", "C4", 2009, 65000, "sand metal", CarStatus.AVAILABLE)));
            log.info("Preloading " + repository.save(new Car("Audi", "A6", 2019, 30000, "silver", CarStatus.RENTED)));
            };
        }
    
}
