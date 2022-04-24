package com.gmail.evanloafakahaitao.hwk.hwk9.task3.employees;

import com.gmail.evanloafakahaitao.hwk.hwk9.task3.EmployeeService;
import com.gmail.evanloafakahaitao.hwk.hwk9.task3.HourlySalaryService;

public class TherapistEmployeeServiceAndHourlySalaryServiceImpl extends EmployeeService implements HourlySalaryService {

    private int workHours = 0;

    public TherapistEmployeeServiceAndHourlySalaryServiceImpl(String firstName, String lastName, String department, String position) {
        super(firstName, lastName, department, position);
    }

    @Override
    public double pay() {
        return HOURLY_RATE * workHours;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }
}
