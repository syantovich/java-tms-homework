package syantovich.org.enums;

public enum EWorkerTypes {
    DIRECTOR("Director"),
    WORKER("Worker");
    public final String displayName;

    EWorkerTypes(String displayName) {
        this.displayName = displayName;
    }
}
