package unimaku.demo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CarController {

    private final CarRepository repository;

    private final CarModelAssembler assembler;

    CarController(CarRepository repository, CarModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    // Aggregate root

    @GetMapping("/cars")
    CollectionModel<EntityModel<Car>> all() {

        List<EntityModel<Car>> cars = repository.findAll()
            .stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());

        return CollectionModel.of(cars, 
            linkTo(methodOn(CarController.class).all()).withSelfRel()
        );
    }

    @PostMapping("/cars")
    ResponseEntity<?> newCar(@RequestBody Car newCar) {

        EntityModel<Car> entityModel = assembler.toModel(repository.save(newCar));

        return ResponseEntity
            .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
            .body(entityModel);
    }

    // Single item

    @GetMapping("/cars/{id}")
    EntityModel<Car> one(@PathVariable Long id) {
        
        Car car = repository.findById(id)
            .orElseThrow(() -> new CarNotFoundException(id));
        return assembler.toModel(car);
    }

    @PutMapping("/cars/{id}")
    ResponseEntity<?> replaceCar(@RequestBody Car newCar, @PathVariable Long id) {

        Car updatedCar = repository.findById(id)
            .map(car -> {
                car.setType(newCar.getType());
                car.setModel(newCar.getModel());
                car.setYearMade(newCar.getYearMade());
                car.setMileage(newCar.getMileage());
                car.setColour(newCar.getColour());
                car.setStatus(newCar.getStatus());
                return repository.save(newCar);
            })
            .orElseGet(() -> {
                newCar.setId(id);
                return repository.save(newCar);
            });
        
        EntityModel<Car> entityModel = assembler.toModel(updatedCar);

        return ResponseEntity
            .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
            .body(entityModel);
    }

    @DeleteMapping("/cars/{id}")
    ResponseEntity<?> deleteCar(@PathVariable Long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
    
}
