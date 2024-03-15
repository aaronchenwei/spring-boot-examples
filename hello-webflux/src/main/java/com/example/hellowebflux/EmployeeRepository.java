package com.example.hellowebflux;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeRepository {
  private static final Map<String, Employee> EMPLOYEE_DATA;

  private static final int MAX_NUMBER_EMPLOYEE = 1000;

  static {
    EMPLOYEE_DATA = new HashMap<>();

    for (int i = 1; i <= MAX_NUMBER_EMPLOYEE; i++) {
      String idx = Integer.toString(i);
      EMPLOYEE_DATA.put(idx, new Employee(idx, "Employee " + idx));
    }
  }

  public Mono<Employee> findEmployeeById(String id) {
    return Mono.just(EMPLOYEE_DATA.get(id));
  }

  public Flux<Employee> findAllEmployees() {
    return Flux.fromIterable(EMPLOYEE_DATA.values());
  }

  public Mono<Employee> updateEmployee(Employee employee) {
    Employee existingEmployee = EMPLOYEE_DATA.get(employee.getId());
    if (existingEmployee != null) {
      existingEmployee.setName(employee.getName());
    }
    return Mono.just(existingEmployee);
  }
}
