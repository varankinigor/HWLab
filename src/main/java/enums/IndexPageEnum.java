package enums;

public enum IndexPageEnum {
    //    URL("https://jdi-framework.github.io/tests"),
    URL("https://epam.github.io/JDI/index.html"),
    TITLE("Home Page"),
    LOGIN("epam"),
    PASSWORD("1234"),
    NAME("PITER CHAILOVSKII");

    public String text;

    IndexPageEnum(String text) {
        this.text = text;
    }
}
