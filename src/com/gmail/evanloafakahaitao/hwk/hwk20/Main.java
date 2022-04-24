package com.gmail.evanloafakahaitao.hwk.hwk20;

public class Main {

    public static void main(String[] args) {
        String schema = "src\\com\\gmail\\evanloafakahaitao\\hwk\\hwk20\\schema.xsd";
        String xml = "src\\com\\gmail\\evanloafakahaitao\\hwk\\hwk20\\sample.xml";

        boolean isValid = XMLValidatorService.validateXmlAgainstSchema(xml, schema);
        System.out.println("XML valid against Schema : " + isValid);
    }
}
