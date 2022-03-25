package org.cucumber.framework;

public enum LocatorsEnum {

    BASE_LINK("//a[text()='%s']"),
    BASE_BUTTON("//input[@value='%s']"),
    BASE_BUTTON_NAME("//input[@name='%s']"),
    BASE_TEXT_FIELD_ID("//input[@id='%s']"),
    BASE_TEXT_FIELD_NAME("//input[@name='%s']");

    private final String text;
    LocatorsEnum(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }
}
