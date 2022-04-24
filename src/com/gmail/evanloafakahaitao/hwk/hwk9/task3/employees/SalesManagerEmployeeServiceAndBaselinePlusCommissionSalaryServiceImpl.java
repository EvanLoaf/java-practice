package com.gmail.evanloafakahaitao.hwk.hwk9.task3.employees;

import com.gmail.evanloafakahaitao.hwk.hwk9.task3.BaselinePlusCommissionSalaryService;
import com.gmail.evanloafakahaitao.hwk.hwk9.task3.EmployeeService;

public class SalesManagerEmployeeServiceAndBaselinePlusCommissionSalaryServiceImpl extends EmployeeService implements BaselinePlusCommissionSalaryService {

    private double salesVolume = 0;

    public SalesManagerEmployeeServiceAndBaselinePlusCommissionSalaryServiceImpl(String firstName, String lastName, String department, String position) {
        super(firstName, lastName, department, position);
    }

    @Override
    public double pay() {
        return BASELINE + PERCENTAGE_OF_SALES / 100 * salesVolume;
    }

    public double getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(double salesVolume) {
        this.salesVolume = salesVolume;
    }
}
