package com.gmail.evanloafakahaitao.hwk.hwk9.task3.employees;

import com.gmail.evanloafakahaitao.hwk.hwk9.task3.EmployeeService;
import com.gmail.evanloafakahaitao.hwk.hwk9.task3.MonthlySalaryService;

public class LawyerEmployeeServiceAndMonthlySalaryServiceImpl extends EmployeeService implements MonthlySalaryService {

    private int sickDays = 0;

    public LawyerEmployeeServiceAndMonthlySalaryServiceImpl(String firstName, String lastName, String department, String position) {
        super(firstName, lastName, department, position);

    }

    @Override
    public double pay() {
        return MONTHLY_RATE * (WORKING_HOURS - sickDays * 8) / WORKING_HOURS >= 0 ? MONTHLY_RATE * (WORKING_HOURS - sickDays * 8) / WORKING_HOURS : 0;
    }

    public int getSickDays() {
        return sickDays;
    }

    public void setSickDays(int sickDays) {
        this.sickDays = sickDays;
    }
}
