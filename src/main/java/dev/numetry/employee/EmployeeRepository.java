package dev.numetry.employee;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee, ObjectId> {
    Optional<Employee> findByEid(String eid);
    void deleteByEid(String eid);
}
