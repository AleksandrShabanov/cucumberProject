package org.cucumber.framework;

public enum LocatorsEnum {

    BASE_LINK("//a[text()='%s']"),
    BASE_BUTTON("")
    ;

    private final String text;

    LocatorsEnum(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
