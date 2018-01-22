package enums.hw3;

public enum IndexPageTextsEnum {
    URL("https://jdi-framework.github.io/tests"),
    TITLE("Index Page"),
    LOGIN("epam"),
    PASSWORD("1234"),
    NAME("PITER CHAILOVSKII"),
    TEXT_1("To include good practices\nand ideas from successful\nEPAM projec"),
    TEXT_2("To be flexible and\ncustomizable"),
    TEXT_3("To be multiplatform"),
    TEXT_4("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    public String text;

    IndexPageTextsEnum(String text) {
        this.text = text;
    }
}
