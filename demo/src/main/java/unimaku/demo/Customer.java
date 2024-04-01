package unimaku.demo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
class Customer {
    
    private @Id @GeneratedValue Long id;
    private String name;
    private String email;
    // private String[] history;

    Customer() {}

    Customer(String name, String email) {
        this.name = name;
        this.email = email;
        // this.history = history;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // public String[] getHistory() {
    //     return this.history;
    // }

    // public void setHistory(String[] history) {
    //     this.history = history;
    // }

    @Override
    public boolean equals(Object o) {

        if(this == o)
        return true;
        if(!(o instanceof Customer))
        return false;
        Customer customer = (Customer) o;
        return Objects.equals(this.id, customer.id) && 
                Objects.equals(this.name, customer.name) &&
                Objects.equals(this.email, customer.email); // &&
                // Objects.equals(this.history, customer.history);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.email);
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + this.id + ", name='" + this.name + '\'' + ", email='" + this.email + '}';
    }

}
