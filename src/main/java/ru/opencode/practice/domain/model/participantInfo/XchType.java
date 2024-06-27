package ru.opencode.practice.domain.model.participantInfo;

public enum XchType {
    T0("0"),
    T1("1");

    private String value;

    XchType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
