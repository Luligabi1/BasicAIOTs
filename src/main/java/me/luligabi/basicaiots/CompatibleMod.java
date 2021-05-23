package me.luligabi.basicaiots;

public enum CompatibleMod {
    INDUSTRIAL_REVOLUTION("indrev"),
    TECHREBORN("techreborn"),
    BEWITCHMENT("bewitchment");

    private final String id;

    CompatibleMod(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
