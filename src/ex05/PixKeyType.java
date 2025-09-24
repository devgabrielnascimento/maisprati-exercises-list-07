package ex05;
public enum PixKeyType {
    CPF("\\d{11}"),
    EMAIL(".+@.+"),
    PHONE("\\+\\d+"),
    UUID("[0-9a-fA-F\\-]{36}");

    private final String regex;

    PixKeyType(String regex) {
        this.regex = regex;
    }

    public boolean isValid(String value) {
        return value != null && value.matches(regex);
    }
}