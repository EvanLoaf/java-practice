package com.gmail.evanloafakahaitao.hwk.hwk24.sql;

import com.gmail.evanloafakahaitao.util.InputService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SqlScriptService {

    public void writeSqlToFile() {
        String path = "my\\office.sql";
        StringBuilder sb = new StringBuilder();
        sb.append("create database office;");
        sb.append(System.lineSeparator());
        sb.append("use office;");
        sb.append(System.lineSeparator());
        sb.append("create table employees(id int not null auto_increment primary key, first_name varchar(30) null, ")
                .append("last_name varchar(30) null, salary int null, title enum('junior', 'middle', 'senior') not null default 'junior');");
        sb.append(System.lineSeparator());
        sb.append("insert into employees (first_name, last_name, salary) values");
        for (int i = 0; i < 20; i++) {
            sb.append(
                    String.format("('my_name%d', 'last%d', %d)", i, i, InputService.getRandomNumberInRange(300, 3000))
            );
            if (i < 19) sb.append(",");
        }
        sb.append(";");
        sb.append(System.lineSeparator());
        sb.append("select * from employees;");
        sb.append(System.lineSeparator());
        sb.append("update employees set title = 2 where salary between 1000 and 1500;");
        sb.append(System.lineSeparator());
        sb.append("select * from employees;");
        sb.append(System.lineSeparator());
        sb.append("update employees set title = 3 where salary > 1500;");
        sb.append(System.lineSeparator());
        sb.append("select * from employees;");
        sb.append(System.lineSeparator());
        sb.append("delete from employees where salary < 700");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            if (sb.length() > 0) bw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
