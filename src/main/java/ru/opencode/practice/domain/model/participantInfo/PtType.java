package ru.opencode.practice.domain.model.participantInfo;

public enum PtType {

    N00("00"),
    N10("10"),
    N12("12"),
    N15("15"),
    N20("20"),
    N30("30"),
    N40("40"),
    N51("51"),
    N52("52"),
    N60("60"),
    N65("65"),
    N71("71"),
    N75("75"),
    N78("78"),
    N90("90"),
    N99("99");

    private String value;
    PtType (String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
