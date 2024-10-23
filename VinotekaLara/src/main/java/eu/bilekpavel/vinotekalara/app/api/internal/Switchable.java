package eu.bilekpavel.vinotekalara.app.api.internal;

public interface Switchable {
    void setActiveState();
    void setInactiveState();
    boolean isInActiveState();
}
