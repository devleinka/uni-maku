package unimaku.demo;

import org.springframework.data.jpa.repository.JpaRepository;

interface CarRepository extends JpaRepository<Car, Long> {
    
}
