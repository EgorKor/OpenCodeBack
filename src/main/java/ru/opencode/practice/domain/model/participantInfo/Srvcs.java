package ru.opencode.practice.domain.model.participantInfo;

public enum Srvcs {
    S1("1"),
    S2("2"),
    S3("3"),
    S4("4"),
    S5("5"),
    S6("6");

    private String value;
    Srvcs(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
