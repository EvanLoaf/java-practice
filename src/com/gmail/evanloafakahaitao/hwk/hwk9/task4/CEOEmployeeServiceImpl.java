package com.gmail.evanloafakahaitao.hwk.hwk9.task4;

public class CEOEmployeeServiceImpl implements EmployeeService {

    private String name;
    private String position;

    public CEOEmployeeServiceImpl(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public String showPosition() {
        return String.format("Employee name: %s || Position: %s", this.name, this.position);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
