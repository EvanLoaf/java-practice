package com.gmail.evanloafakahaitao.hwk.hwk9;

import com.gmail.evanloafakahaitao.hwk.hwk9.task1.CircleFiguresServiceImpl;
import com.gmail.evanloafakahaitao.hwk.hwk9.task1.FiguresService;
import com.gmail.evanloafakahaitao.hwk.hwk9.task1.SquareFiguresServiceImpl;
import com.gmail.evanloafakahaitao.hwk.hwk9.task1.TriangleFiguresServiceImpl;
import com.gmail.evanloafakahaitao.hwk.hwk9.task3.employees.LawyerEmployeeServiceAndMonthlySalaryServiceImpl;
import com.gmail.evanloafakahaitao.hwk.hwk9.task3.employees.SalesManagerEmployeeServiceAndBaselinePlusCommissionSalaryServiceImpl;
import com.gmail.evanloafakahaitao.hwk.hwk9.task3.employees.SalesPersonEmployeeServiceAndCommissionSalaryServiceImpl;
import com.gmail.evanloafakahaitao.hwk.hwk9.task3.employees.TherapistEmployeeServiceAndHourlySalaryServiceImpl;
import com.gmail.evanloafakahaitao.hwk.hwk9.task4.AccountantEmployeeServiceImpl;
import com.gmail.evanloafakahaitao.hwk.hwk9.task4.CEOEmployeeServiceImpl;
import com.gmail.evanloafakahaitao.hwk.hwk9.task4.WorkerEmployeeServiceImpl;
import com.gmail.evanloafakahaitao.util.InputService;

public class Main {

    public static void main(String[] args) {
        System.out.println("How many figures to create?");
        int numOfFigures = InputService.getNumber();
        FiguresService[] figures = new FiguresService[numOfFigures];
        int randomFigure;
        for (int i = 0; i < numOfFigures; i++) {
            randomFigure = InputService.getRandomNumberInRange(1, 3);
            if (randomFigure == 1) {
                figures[i] = new TriangleFiguresServiceImpl(
                        InputService.getRandomNumberInRange(6, 10),
                        InputService.getRandomNumberInRange(6, 10),
                        InputService.getRandomNumberInRange(6, 10)
                );
            } else if (randomFigure == 2) {
                figures[i] = new CircleFiguresServiceImpl(InputService.getRandomNumberInRange(1, 10));
            } else {
                figures[i] = new SquareFiguresServiceImpl(
                        InputService.getRandomNumberInRange(1, 10),
                        InputService.getRandomNumberInRange(1, 10)
                );
            }
        }
        double sumOfPerimeters = 0;
        for (FiguresService figure : figures) {
            sumOfPerimeters += figure.perimeter();
        }
        System.out.println("Sum of all perimeters: " + sumOfPerimeters);


        String salaryPrint = "Salary of %s is %f";
        LawyerEmployeeServiceAndMonthlySalaryServiceImpl lawyer = new LawyerEmployeeServiceAndMonthlySalaryServiceImpl(
                "Ian", "Dawson", "Legal", "Chief Lawyer"
        );
        lawyer.setSickDays(10);
        System.out.println(String.format(salaryPrint, lawyer.getPosition(), lawyer.pay()));

        TherapistEmployeeServiceAndHourlySalaryServiceImpl therapist = new TherapistEmployeeServiceAndHourlySalaryServiceImpl(
                "Angela", "Dark", "External", "Masseur"
        );
        therapist.setWorkHours(22);
        System.out.println(String.format(salaryPrint, therapist.getPosition(), therapist.pay()));

        SalesPersonEmployeeServiceAndCommissionSalaryServiceImpl salesman = new SalesPersonEmployeeServiceAndCommissionSalaryServiceImpl(
                "Richard", "Smoore", "Sales", "Sales Person"
        );
        salesman.setSalesVolume(800);
        System.out.println(String.format(salaryPrint, salesman.getPosition(), salesman.pay()));

        SalesManagerEmployeeServiceAndBaselinePlusCommissionSalaryServiceImpl manager = new SalesManagerEmployeeServiceAndBaselinePlusCommissionSalaryServiceImpl(
                "Dan", "Woke", "Sales", "Sales Manager"
        );
        manager.setSalesVolume(1500);
        System.out.println(String.format(salaryPrint, manager.getPosition(), manager.pay()));


        CEOEmployeeServiceImpl ceo = new CEOEmployeeServiceImpl(
                "Robert Hoyte", "C_E_O_EPT"
        );
        System.out.println(ceo.showPosition());
        AccountantEmployeeServiceImpl accountant = new AccountantEmployeeServiceImpl(
                "Mitchell Blake", "Accountant"
        );
        System.out.println(accountant.showPosition());
        WorkerEmployeeServiceImpl worker = new WorkerEmployeeServiceImpl(
                "Bill Davis", "Normal Worker"
        );
        System.out.println(worker.showPosition());
    }
}
