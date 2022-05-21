package com.example.NachislenieZP.repository;

import com.example.NachislenieZP.models.EmployeeModel;

import java.util.*;



public final class EmployeeRepository {
    private EmployeeRepository() {
    }

    private static List<EmployeeModel> employeeRepository = new ArrayList<>();

    public static void insertEmployee(EmployeeModel employeeModel) {
        employeeRepository.add(employeeModel);
    }

    public static List<EmployeeModel> getAll() {
        return employeeRepository;
    }

    public static void delete(String name) {
        Iterator<EmployeeModel> employeesIterator = employeeRepository.iterator();
        while (employeesIterator.hasNext()) {
            EmployeeModel nextEmployee = employeesIterator.next();
            if (nextEmployee.getName().equals(name)) {
                employeesIterator.remove();
            }
        }
    }

    public static void editEmployee(long id, String name, String post, int salary) {
        Iterator<EmployeeModel> employeesIterator = employeeRepository.iterator();
        while (employeesIterator.hasNext()) {
            EmployeeModel nextEmployee = employeesIterator.next();
            final long employeeId = nextEmployee.getId();
            if (employeeId == id) {
                nextEmployee.setName(name);
                nextEmployee.setPost(post);
                nextEmployee.setSalary(salary);
            }
        }
    }

    public static String getEmployeeNameById(int id) {
        Iterator<EmployeeModel> employeesIterator = employeeRepository.iterator();
        while (employeesIterator.hasNext()) {
            EmployeeModel nextEmployee = employeesIterator.next();
            final long employeeId = nextEmployee.getId();
            if (employeeId == id) {
                return nextEmployee.getName();
            }
        }
        return "Null";
    }

}
