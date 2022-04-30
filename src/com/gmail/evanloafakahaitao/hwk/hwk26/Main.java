package com.gmail.evanloafakahaitao.hwk.hwk26;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        CityApp cityApp = CityApp.getInstance();
        cityApp.runApp();

        Pattern p = Pattern.compile("(?!.*?\\s{2,}.*?)[\\d\\sa-zA-Z]{1,100}");
        String input = "hey  there";
        Matcher matcher = p.matcher(input);
        System.out.println(matcher.matches());
    }
}
