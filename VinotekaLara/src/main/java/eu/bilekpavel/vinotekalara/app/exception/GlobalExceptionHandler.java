package eu.bilekpavel.vinotekalara.app.exception;

import eu.bilekpavel.vinotekalara.translator.error.LocalizedStringException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LocalizedStringException.class)
    public String handleAlertError(LocalizedStringException e, RedirectAttributes ra) {
        ra.addFlashAttribute("_alert_message", e.getMessage());
        return "redirect:/home";
    }
}