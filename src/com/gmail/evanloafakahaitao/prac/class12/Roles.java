package com.gmail.evanloafakahaitao.prac.class12;

public enum Roles {

    ADMIN("VERYCOOLADMIN", "UNLIMITED"),
    CUSTOMER("OKAYISH", "PURCHASE"),
    USER("WASTE OF TIME", "PURCHASE");

    private String description;
    private String authority;

    Roles(String description, String authority) {
        this.description = description;
        this.authority = authority;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthority() {
        return authority;
    }

    public String getFullInfo() {
        return String.format("Name: %s, Descr : %s, Authority: %s", this.toString(), description, authority);
    }
}
