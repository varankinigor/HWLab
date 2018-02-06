package enums;

public enum IndexPageEnum {
//    использую новую версию сайта, так как в старой слайдеры цепляются только во время дебага, но никак не при прогоне теста?!?!??!
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
