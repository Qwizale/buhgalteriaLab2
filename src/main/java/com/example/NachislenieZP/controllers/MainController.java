package com.example.NachislenieZP.controllers;

import com.example.NachislenieZP.models.EmployeeModel;
import com.example.NachislenieZP.models.SalaryModel;
import com.example.NachislenieZP.repository.EmployeeRepository;
import com.example.NachislenieZP.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public final class MainController {


    @GetMapping("/")
    public String main(Model model) {
        List<EmployeeModel> employees = new ArrayList<>();
        employees.addAll(EmployeeRepository.getAll());
        model.addAttribute("employees", employees);
        return "main";
    }

    @GetMapping("/add")
    public String add(Model model) {
        return "add";
    }

    @GetMapping("/delete")
    public String delete(Model model) {
        return "delete";
    }

    @GetMapping("/edit")
    public String edit(Model model) {
        return "edit";
    }

    @GetMapping("/accrual")
    public String accrual(Model model) {
        List<SalaryModel> salary = new ArrayList<>();
        salary.addAll(SalaryRepository.getAll());
        model.addAttribute("salary", salary);
        return "accrual";
    }

    @PostMapping("/add")
    public String employeeAdd(@RequestParam String name, @RequestParam String post, @RequestParam int salary, Model model) {
        EmployeeModel employeeModel = new EmployeeModel(name, post, salary);
        EmployeeRepository.insertEmployee(employeeModel);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String employeeEdit(@RequestParam String name, Model model) {
        List<EmployeeModel> employees = new ArrayList<>();
        employees.addAll(EmployeeRepository.getAll());
        EmployeeRepository.delete(name);
        return "redirect:/";
    }

    @PostMapping("/edit")
    public String employeeEdit(@RequestParam long id, @RequestParam String name, @RequestParam String post, @RequestParam int salary, Model model) {
        EmployeeRepository.editEmployee(id, name, post, salary);
        return "redirect:/";
    }

    @PostMapping("/accrual")
    public String accrualAdd(@RequestParam int id, @RequestParam String date, @RequestParam int summ, Model model) {
        SalaryModel salaryModel = new SalaryModel(id, date, summ);
        SalaryRepository.insertSalary(salaryModel);
        return "redirect:/";
    }
}
