package dev.numetry.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping
    public ResponseEntity<List<Employee>> getallemployee(){
        return new ResponseEntity<List<Employee>>(employeeService.allEmployee(),HttpStatus.OK);
    }



    @GetMapping("/{eid}")
    public ResponseEntity<Optional<Employee>> getSingleEmployee(@PathVariable String eid){
        return new ResponseEntity<Optional<Employee>>(employeeService.singleEmployee(eid),HttpStatus.OK);
    }

    @PostMapping("/createEmployee")
        public ResponseEntity<Optional<Employee>> createEmployee(@RequestBody Employee employee ){
            return new ResponseEntity<Optional<Employee>>(employeeService.createEmployee(employee), HttpStatus.OK);
    }
    @PostMapping("/updateEmployee")
        public ResponseEntity<Optional<Employee>> updateEmployee(@RequestBody Employee employee ){
            return new ResponseEntity<Optional<Employee>>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }
    @PostMapping("/deleteEmployee")
    public ResponseEntity<Optional<Employee>> deleteEmployee(@RequestBody Employee employee ){
        System.out.println(employee);
        return new ResponseEntity<Optional<Employee>>(employeeService.deleteEmployee(employee.getEid()), HttpStatus.OK);
    }
}
