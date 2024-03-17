package syantovich.org.enums;

public enum CatTypes {
    BRITISH("British cat"),
    SIAM("Siamskii cat"),
    STREET("Street cat");

    private String name;

    CatTypes(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
