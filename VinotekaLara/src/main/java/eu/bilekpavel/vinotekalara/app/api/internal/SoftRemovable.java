package eu.bilekpavel.vinotekalara.app.api.internal;

public interface SoftRemovable {
    void remove();
    void restore();
    boolean isRemoved();
}
