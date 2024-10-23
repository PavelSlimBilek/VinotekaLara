package eu.bilekpavel.vinotekalara.app.translator.internal;

import eu.bilekpavel.vinotekalara.app.translator.CoreTranslator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AbstractCoreTranslator implements CoreTranslator {
    private final String APPLICATION;
    private final String SETTINGS;
    private final String PREVIEW;
    private final String NAME;
    private final String ALLOW;
    private final String ALLOWED;
    private final String FORBID;
    private final String FORBIDDEN;
    private final String ACTIVATE;
    private final String SUBMIT;
    private final String EDIT;
    private final String BACK;
    private final String DELETE;
    private final String CREATE;
    private final String APPLY;
    private final String TRANSLATOR;


    @Override
    public String application() {
        return APPLICATION;
    }

    @Override
    public String settings() {
        return SETTINGS;
    }

    @Override
    public String preview() {
        return PREVIEW;
    }

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public String allow() {
        return ALLOW;
    }

    @Override
    public String allowed() {
        return ALLOWED;
    }

    @Override
    public String forbid() {
        return FORBID;
    }

    @Override
    public String forbidden() {
        return FORBIDDEN;
    }

    @Override
    public String activate() {
        return ACTIVATE;
    }

    @Override
    public String submit() {
        return SUBMIT;
    }

    @Override
    public String edit() {
        return EDIT;
    }

    @Override
    public String back() {
        return BACK;
    }

    @Override
    public String delete() {
        return DELETE;
    }

    @Override
    public String create() {
        return CREATE;
    }

    @Override
    public String apply() {
        return APPLY;
    }

    @Override
    public String translator() {
        return TRANSLATOR;
    }
}
