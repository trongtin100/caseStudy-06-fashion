package com.fashion.controller;

import com.fashion.model.dto.CustomerDto;
import com.fashion.model.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping
    public ResponseEntity<Iterable<CustomerDto>> findAll() {
        List<CustomerDto> customers = (List<CustomerDto>) customerService.findAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findById(@PathVariable Long id) {
        Optional<CustomerDto> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> save(@Valid @RequestBody CustomerDto customerDto, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors.toString());
        }
        return ResponseEntity.ok("Customer created successfully");
    }


    @PutMapping("")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CustomerDto customerDto) {
        Optional<CustomerDto> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerDto.setId(customerOptional.get().getId());
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDto> delete(@PathVariable Long id) {
        Optional<CustomerDto> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.remove(id);
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.NO_CONTENT);
    }

}

