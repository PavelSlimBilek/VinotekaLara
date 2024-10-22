package eu.bilekpavel.vinotekalara.superadmin.translator.languages;

import eu.bilekpavel.vinotekalara.superadmin.translator.AbstractAdminTranslator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("ukrainianAdmin")
public class UkrainianAdminTranslator extends AbstractAdminTranslator {
    public UkrainianAdminTranslator() {
        super(
                "налаштування",
                "години роботи",
                "додаток",
                "дозволити",
                "заборонити",
                "активувати",
                "надіслати",
                "редагувати",
                "назад",
                "вибрати глобальні години роботи",
                "поточні години роботи",
                "видалити",
                "створити",
                "ім'я",
                "застосувати",
                "вибрати мову за замовчуванням",
                "дозволити/заборонити мови",
                "налаштування додатка",
                "оновити локалізації",
                "колір фону",
                "червоний",
                "зелений",
                "синій"
        );
    }
}
