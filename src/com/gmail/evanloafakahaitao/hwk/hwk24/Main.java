package com.gmail.evanloafakahaitao.hwk.hwk24;

import com.gmail.evanloafakahaitao.hwk.hwk24.sql.SqlScriptService;

public class Main {

    public static void main(String[] args) {
        SqlScriptService sqlScriptService = new SqlScriptService();
        sqlScriptService.writeSqlToFile();
    }
}
