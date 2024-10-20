package eu.bilekpavel.vinotekalara.superadmin.translator.languages;

import eu.bilekpavel.vinotekalara.superadmin.translator.AbstractAdminTranslator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("ukrainianAdmin")
public class UkrainianAdminTranslator extends AbstractAdminTranslator {
    public UkrainianAdminTranslator() {
        super(
                "налаштування",                     // settings
                "години роботи",                    // opening hours
                "додаток",                          // application
                "попереджувальна панель",            // alert bar
                "дозволити",                        // allow
                "заборонити",                       // forbid
                "активувати",                       // activate
                "надіслати",                        // submit
                "редагувати",                       // edit
                "назад",                            // back
                "вибрати глобальні години роботи",  // select global opening hours
                "поточні години роботи",             // current opening hours
                "видалити",                         // remove
                "створити",                        // create
                "ім'я",                             // name
                "застосувати",                      // apply
                "вибрати мову за замовчуванням",   // select default language
                "дозволити/заборонити мови",       // allow/forbid languages
                "налаштування додатка",            // app settings
                "дозволити попереджувальну панель", // allow alert bar
                "показувати попереджувальну панель", // display alert bar
                "вибрати активну попереджувальну панель", // select active alert bar
                "створити нове попередження"       // create new alert
        );
    }
}
