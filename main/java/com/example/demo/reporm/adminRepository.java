package com.example.demo.reporm;

import com.example.demo.Models.admin;
import org.springframework.data.repository.CrudRepository;

public interface adminRepository extends CrudRepository<admin,Long> {
    admin findByUsername(String username);
    admin save(admin admin);
}
