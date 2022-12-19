package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    private PersonRepository personRepository;
 @Autowired
    public PersonController(PersonRepository personRepository){
        this.personRepository =personRepository;
    }
    @PostMapping("/people")
    public ResponseEntity<Person> createPerson(@RequestBody Person p) {
        return new ResponseEntity<>(personRepository.save(p), HttpStatus.CREATED);
    }
   @GetMapping("/{id}")
        public ResponseEntity<Person> getPerson(@PathVariable int id){
            return new ResponseEntity<>(personRepository.findOne(id) , HttpStatus.OK);
        }
    @GetMapping("/people")
    public ResponseEntity<List<Person>> getPersonList() {
        return new ResponseEntity<>((List<Person>) personRepository.findAll(), HttpStatus.OK);
    }
    @PutMapping("/people/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id ,@RequestBody Person p){
        if(personRepository.findBy(id) != null) {
            return new ResponseEntity<>(personRepository.findById(id), HttpStatus.OK);
        } else
            return new ResponseEntity<>(personRepository.save(p), HttpStatus.CREATED);

    }
    @DeleteMapping("/people/{id}")

    public void DeletePerson(@PathVariable int id){
        // @ResponseStatus(HttpStatus.NO_CONTENT);
        personRepository.delete(id);


    }
}
