package eu.bilekpavel.vinotekalara.app;

import eu.bilekpavel.vinotekalara.alertbar.error.AlertValidationError;
import eu.bilekpavel.vinotekalara.translator.error.LocalizedStringException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AlertValidationError.class)
    public String handleAlertError(AlertValidationError e, RedirectAttributes ra) {
        ra.addFlashAttribute("_alert_message", e.getMessage());
        return "redirect:/home";
    }

    @ExceptionHandler(LocalizedStringException.class)
    public String handleLocalizedStringError(LocalizedStringException e, RedirectAttributes ra) {
        ra.addFlashAttribute("_alert_message", e.getMessage());
        return "redirect:/home";
    }
}