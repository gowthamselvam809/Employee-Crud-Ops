package dev.numetry.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired

    private EmployeeRepository employeeRepository;

    public List<Employee> allEmployee(){
        return employeeRepository.findAll();
    }
    public Optional<Employee> singleEmployee(String eid){
        return employeeRepository.findByEid(eid);
    }

    public  Optional<Employee>  createEmployee(Employee employee){
        employeeRepository.insert(employee);
        return Optional.of(employee);
    }

    public Optional<Employee> updateEmployee(Employee updatedEmployee) {
        Optional<Employee> existingEmployee = employeeRepository.findByEid(updatedEmployee.getEid());

        if (existingEmployee.isPresent()) {
            Employee employeeToUpdate = existingEmployee.get();
            employeeToUpdate.setName(updatedEmployee.getName());
            employeeToUpdate.setMobile(updatedEmployee.getMobile());

            employeeRepository.save(employeeToUpdate);

            return Optional.of(employeeToUpdate);
        } else{
            return Optional.empty();
        }
    }

    public Optional<Employee> deleteEmployee(String eid){
        System.out.println(eid);
        Optional<Employee> employee = employeeRepository.findByEid(eid);
        System.out.println(employee);
        if (employee.isPresent()) {
            employeeRepository.deleteByEid(eid);
        }

        return employee;
    }



}
