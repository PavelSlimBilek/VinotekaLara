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
                "попереджувальна панель",
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
                "дозволити попереджувальну панель",
                "показувати попереджувальну панель",
                "вибрати активну попереджувальну панель",
                "створити нове попередження",
                "оновити локалізації",
                "колір фону",
                "червоний",
                "зелений",
                "синій"
        );
    }
}
