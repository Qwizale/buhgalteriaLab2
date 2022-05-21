package com.example.NachislenieZP.repository;

import com.example.NachislenieZP.models.SalaryModel;

import java.util.ArrayList;
import java.util.List;

public final class SalaryRepository {

    private SalaryRepository() {}

    private static List<SalaryModel> salaryRepository = new ArrayList<>();

    public static void insertSalary(SalaryModel salaryModel) { salaryRepository.add(salaryModel); }

    public static List<SalaryModel> getAll() { return salaryRepository; }

}
