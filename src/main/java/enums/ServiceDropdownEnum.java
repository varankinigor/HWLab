package enums;

public enum ServiceDropdownEnum {
    TEXT_1("SUPPORT"),
    TEXT_2("DATES"),
    TEXT_3("COMPLEX TABLE"),
    TEXT_4("SIMPLE TABLE"),
    TEXT_5("USER TABLE"),
    TEXT_6("TABLE WITH PAGES"),
    TEXT_7("DIFFERENT ELEMENTS");

    public String text;

    ServiceDropdownEnum(String text) {
        this.text = text;
    }
}
