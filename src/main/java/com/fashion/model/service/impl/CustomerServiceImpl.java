package com.fashion.model.service.impl;


import com.fashion.model.dto.CustomerDto;
import com.fashion.model.entity.Customer;
import com.fashion.model.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Iterable<CustomerDto> findAll() {
        Iterable<Customer> entities = customerRepository.findAll();
        return StreamSupport.stream(entities.spliterator(), true)
                .map(entity -> modelMapper.map(entity, CustomerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerDto> findById(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        return Optional.of(modelMapper.map(customer, CustomerDto.class));
    }

    @Override
    public void save(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    public String uploadAvatar(MultipartFile file) {
        customerRepository.save(avatar.builder())
                .name
    }

}

