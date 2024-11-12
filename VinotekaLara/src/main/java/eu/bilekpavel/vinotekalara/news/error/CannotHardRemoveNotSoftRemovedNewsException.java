package eu.bilekpavel.vinotekalara.news.error;

public class CannotHardRemoveNotSoftRemovedNewsException extends NewsException {
    public CannotHardRemoveNotSoftRemovedNewsException(String id) {
        super("Cannot remove news id:" + id + " that are not soft removed");
    }
}
