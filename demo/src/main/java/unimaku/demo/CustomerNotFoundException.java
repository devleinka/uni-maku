package unimaku.demo;

class CustomerNotFoundException extends RuntimeException {
    
    CustomerNotFoundException(Long id) {
        super("Could not find Customer " + id);
    }
}
