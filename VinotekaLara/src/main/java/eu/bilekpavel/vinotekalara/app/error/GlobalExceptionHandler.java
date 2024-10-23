package eu.bilekpavel.vinotekalara.app.error;

import eu.bilekpavel.vinotekalara.translator.error.TranslatorException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public final class GlobalExceptionHandler {

    @ExceptionHandler(TranslatorException.class)
    public String handleAlertError(TranslatorException e, RedirectAttributes ra) {
        ra.addFlashAttribute("_alert_message", e.getMessage());
        return "redirect:/home";
    }
}