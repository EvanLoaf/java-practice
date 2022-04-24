package com.gmail.evanloafakahaitao.hwk.hwk12;

public enum Volume {

    LOW("Can barely hear"),
    MEDIUM("Optimal"),
    HIGH("For crowded spaces");

    private String description;

    Volume(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
