package eu.bilekpavel.vinotekalara;

import eu.bilekpavel.vinotekalara.alertbar.dto.AlertRequest;
import eu.bilekpavel.vinotekalara.alertbar.service.AlertServiceInterface;
import eu.bilekpavel.vinotekalara.news.dto.NewsData;
import eu.bilekpavel.vinotekalara.news.dto.NewsRequest;
import eu.bilekpavel.vinotekalara.news.service.NewsServiceInterface;
import eu.bilekpavel.vinotekalara.openinghours.dto.DailyHours;
import eu.bilekpavel.vinotekalara.openinghours.dto.TimeInterval;
import eu.bilekpavel.vinotekalara.openinghours.model.WeeklyHours;
import eu.bilekpavel.vinotekalara.openinghours.service.WeeklyHoursServiceInterface;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedStringRequest;
import eu.bilekpavel.vinotekalara.translator.language.Language;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class VinotekaLaraApplication implements CommandLineRunner {

	private final AlertServiceInterface alertService;
	private final WeeklyHoursServiceInterface hoursService;
	private final NewsServiceInterface newsService;

	public static void main(String[] args) {
		SpringApplication.run(VinotekaLaraApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("Slim-made");
		System.out.println("---------------------------------------------------");

		AlertRequest alert1 = new AlertRequest(
				List.of(
						new LocalizedStringRequest("Máme nový web!", Language.CZECH.getCode()),
						new LocalizedStringRequest("We have a new website!", Language.ENGLISH.getCode()),
						new LocalizedStringRequest("Wir haben eine neue Website", Language.GERMAN.getCode()),
						new LocalizedStringRequest("У нас новий вебсайт!", Language.UKRAINIAN.getCode()),
						new LocalizedStringRequest("Nous avons un nouveau site web !", Language.FRENCH.getCode())
				), "#7777FF"
		);

		AlertRequest alert2 = new AlertRequest(
				List.of(
						new LocalizedStringRequest("Vytvořeno Liborem Skunkem!", Language.CZECH.getCode()),
						new LocalizedStringRequest("Made by Libor Skunk!", Language.ENGLISH.getCode()),
						new LocalizedStringRequest("Hergestellt von Libor Skunk!", Language.GERMAN.getCode()),
						new LocalizedStringRequest("Створено Лібором Скунком!", Language.UKRAINIAN.getCode()),
						new LocalizedStringRequest("Créé par Libor Skunk !", Language.FRENCH.getCode())
				), "#7777FF"
		);

		alertService.create(alert1);
		alertService.create(alert2);

		alertService.setActive(1);


		DailyHours monday = new DailyHours(
				DayOfWeek.MONDAY,
				new TimeInterval(LocalTime.of(9, 0), LocalTime.of(12, 0)),
				new TimeInterval(LocalTime.of(13, 0), LocalTime.of(18, 0))
		);
		DailyHours tuesday = new DailyHours(
				DayOfWeek.TUESDAY,
				new TimeInterval(LocalTime.of(9, 0), LocalTime.of(12, 0)),
				new TimeInterval(LocalTime.of(13, 0), LocalTime.of(18, 0))
		);
		DailyHours wednesday = new DailyHours(
				DayOfWeek.WEDNESDAY,
				new TimeInterval(LocalTime.of(9, 0), LocalTime.of(12, 0)),
				new TimeInterval(LocalTime.of(13, 0), LocalTime.of(18, 0))
		);
		DailyHours thursday = new DailyHours(
				DayOfWeek.THURSDAY,
				new TimeInterval(LocalTime.of(9, 0), LocalTime.of(12, 0)),
				new TimeInterval(LocalTime.of(13, 0), LocalTime.of(18, 0))
		);
		DailyHours friday = new DailyHours(
				DayOfWeek.FRIDAY,
				new TimeInterval(LocalTime.of(9, 0), LocalTime.of(12, 0)),
				new TimeInterval(LocalTime.of(13, 0), LocalTime.of(18, 0))
		);
		DailyHours saturday = new DailyHours(
				DayOfWeek.SATURDAY,
				new TimeInterval(LocalTime.of(9, 0), LocalTime.of(11, 30)),
				null
		);
		DailyHours sunday = new DailyHours(
				DayOfWeek.SUNDAY,
				null,
				new TimeInterval(LocalTime.of(15, 0), LocalTime.of(17, 30))
		);

		WeeklyHours summerHours = new WeeklyHours();
		summerHours.setMonday(monday);
		summerHours.setTuesday(tuesday);
		summerHours.setWednesday(wednesday);
		summerHours.setThursday(thursday);
		summerHours.setFriday(friday);
		summerHours.setSaturday(saturday);
		summerHours.setSunday(sunday);
		summerHours.setUserIdentifier("Letní hodiny");

		hoursService.save(summerHours);
		hoursService.getGlobalHours(); // to init that

		DailyHours monday2 = new DailyHours(
				DayOfWeek.MONDAY,
				new TimeInterval(LocalTime.of(10, 0), LocalTime.of(12, 0)),
				new TimeInterval(LocalTime.of(13, 0), LocalTime.of(17, 0))
		);
		DailyHours tuesday2 = new DailyHours(
				DayOfWeek.TUESDAY,
				new TimeInterval(LocalTime.of(10, 0), LocalTime.of(12, 0)),
				new TimeInterval(LocalTime.of(13, 0), LocalTime.of(17, 0))
		);
		DailyHours wednesday2 = new DailyHours(
				DayOfWeek.WEDNESDAY,
				new TimeInterval(LocalTime.of(10, 0), LocalTime.of(12, 0)),
				new TimeInterval(LocalTime.of(13, 0), LocalTime.of(17, 0))
		);
		DailyHours thursday2 = new DailyHours(
				DayOfWeek.THURSDAY,
				new TimeInterval(LocalTime.of(10, 0), LocalTime.of(12, 0)),
				new TimeInterval(LocalTime.of(13, 0), LocalTime.of(17, 0))
		);
		DailyHours friday2 = new DailyHours(
				DayOfWeek.FRIDAY,
				new TimeInterval(LocalTime.of(10, 0), LocalTime.of(12, 0)),
				new TimeInterval(LocalTime.of(13, 0), LocalTime.of(17, 0))
		);
		DailyHours saturday2 = new DailyHours(
				DayOfWeek.SATURDAY,
				new TimeInterval(LocalTime.of(10, 0), LocalTime.of(11, 0)),
				null
		);
		DailyHours sunday2 = new DailyHours(
				DayOfWeek.SUNDAY,
				null,
				new TimeInterval(LocalTime.of(15, 0), LocalTime.of(17, 0))
		);

		WeeklyHours winterHours = new WeeklyHours();
		winterHours.setMonday(monday2);
		winterHours.setTuesday(tuesday2);
		winterHours.setWednesday(wednesday2);
		winterHours.setThursday(thursday2);
		winterHours.setFriday(friday2);
		winterHours.setSaturday(saturday2);
		winterHours.setSunday(sunday2);
		winterHours.setUserIdentifier("Zimní hodiny");

		hoursService.save(winterHours);

		System.out.println(
				newsService.create(
						new NewsRequest("Nová novinka!")
				).content()
		);
	}
}