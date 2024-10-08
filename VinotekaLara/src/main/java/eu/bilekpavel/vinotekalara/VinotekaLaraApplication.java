package eu.bilekpavel.vinotekalara;

import eu.bilekpavel.vinotekalara.alertbar.dto.AlertRequest;
import eu.bilekpavel.vinotekalara.alertbar.service.AlertServiceInterface;
import eu.bilekpavel.vinotekalara.openinghours.dto.DailyHours;
import eu.bilekpavel.vinotekalara.openinghours.dto.TimeInterval;
import eu.bilekpavel.vinotekalara.openinghours.model.WeeklyHours;
import eu.bilekpavel.vinotekalara.openinghours.service.WeeklyHoursServiceInterface;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedStringRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@SpringBootApplication
public class VinotekaLaraApplication implements CommandLineRunner {

	private final AlertServiceInterface alertService;
	private final WeeklyHoursServiceInterface hoursService;

	public VinotekaLaraApplication(
			AlertServiceInterface alertService,
			WeeklyHoursServiceInterface hoursService
	) {
		this.alertService = alertService;
		this.hoursService = hoursService;
	}

	public static void main(String[] args) {
		SpringApplication.run(VinotekaLaraApplication.class, args);
	}

	@Override
	public void run(String... args) {
		AlertRequest alert1 = new AlertRequest(
				List.of(
						new LocalizedStringRequest("Máme nový web!", "cz"),
						new LocalizedStringRequest("We have a new website!", "en"),
						new LocalizedStringRequest("Wir haben eine neue Website", "de")
				), "#7777FF"
		);

		AlertRequest alert2 = new AlertRequest(
				List.of(
						new LocalizedStringRequest("Vytvořeno Liborem Skunkem!", "cz"),
						new LocalizedStringRequest("Made by Libor Skunk!", "en"),
						new LocalizedStringRequest("Hergestellt von Libor Skunk!", "de")
				), "#7777FF"
		);

		alertService.create(alert1);
		alertService.create(alert2);

		DailyHours monday = new DailyHours(
				DayOfWeek.MONDAY,
				new TimeInterval(Time.valueOf(LocalTime.of(9, 0)),Time.valueOf(LocalTime.of(12, 0))),
				new TimeInterval(Time.valueOf(LocalTime.of(13, 0)), Time.valueOf(LocalTime.of(18, 0)))
		);
		DailyHours tuesday = new DailyHours(
				DayOfWeek.TUESDAY,
				new TimeInterval(Time.valueOf(LocalTime.of(9, 0)),Time.valueOf(LocalTime.of(12, 0))),
				new TimeInterval(Time.valueOf(LocalTime.of(13, 0)), Time.valueOf(LocalTime.of(18, 0)))
		);
		DailyHours wednesday = new DailyHours(
				DayOfWeek.WEDNESDAY,
				new TimeInterval(Time.valueOf(LocalTime.of(9, 0)),Time.valueOf(LocalTime.of(12, 0))),
				new TimeInterval(Time.valueOf(LocalTime.of(13, 0)), Time.valueOf(LocalTime.of(18, 0)))
		);
		DailyHours thursday = new DailyHours(
				DayOfWeek.THURSDAY,
				new TimeInterval(Time.valueOf(LocalTime.of(9, 0)),Time.valueOf(LocalTime.of(12, 0))),
				new TimeInterval(Time.valueOf(LocalTime.of(13, 0)), Time.valueOf(LocalTime.of(18, 0)))
		);
		DailyHours friday = new DailyHours(
				DayOfWeek.FRIDAY,
				new TimeInterval(Time.valueOf(LocalTime.of(9, 0)),Time.valueOf(LocalTime.of(12, 0))),
				new TimeInterval(Time.valueOf(LocalTime.of(13, 0)), Time.valueOf(LocalTime.of(18, 0)))
		);
		DailyHours saturday = new DailyHours(
				DayOfWeek.SATURDAY,
				new TimeInterval(Time.valueOf(LocalTime.of(9, 0)),Time.valueOf(LocalTime.of(11, 30))),
				null
		);
		DailyHours sunday = new DailyHours(
				DayOfWeek.SUNDAY,
				null,
				new TimeInterval(Time.valueOf(LocalTime.of(15, 0)), Time.valueOf(LocalTime.of(17, 0)))
		);

		WeeklyHours summerHours = new WeeklyHours();
		summerHours.setMonday(monday);
		summerHours.setTuesday(tuesday);
		summerHours.setWednesday(wednesday);
		summerHours.setThursday(thursday);
		summerHours.setFriday(friday);
		summerHours.setSaturday(saturday);
		summerHours.setSunday(sunday);
		summerHours.setUserIdentifier("summer hours");

		hoursService.save(summerHours);

		DailyHours monday2 = new DailyHours(
				DayOfWeek.MONDAY,
				new TimeInterval(Time.valueOf(LocalTime.of(10, 0)),Time.valueOf(LocalTime.of(12, 0))),
				new TimeInterval(Time.valueOf(LocalTime.of(13, 0)), Time.valueOf(LocalTime.of(16, 30)))
		);
		DailyHours tuesday2 = new DailyHours(
				DayOfWeek.TUESDAY,
				new TimeInterval(Time.valueOf(LocalTime.of(10, 0)),Time.valueOf(LocalTime.of(12, 0))),
				new TimeInterval(Time.valueOf(LocalTime.of(13, 0)), Time.valueOf(LocalTime.of(16, 30)))
		);
		DailyHours wednesday2 = new DailyHours(
				DayOfWeek.WEDNESDAY,
				new TimeInterval(Time.valueOf(LocalTime.of(10, 0)),Time.valueOf(LocalTime.of(12, 0))),
				new TimeInterval(Time.valueOf(LocalTime.of(13, 0)), Time.valueOf(LocalTime.of(16, 30)))
		);
		DailyHours thursday2 = new DailyHours(
				DayOfWeek.THURSDAY,
				new TimeInterval(Time.valueOf(LocalTime.of(10, 0)),Time.valueOf(LocalTime.of(12, 0))),
				new TimeInterval(Time.valueOf(LocalTime.of(13, 0)), Time.valueOf(LocalTime.of(16, 30)))
		);
		DailyHours friday2 = new DailyHours(
				DayOfWeek.FRIDAY,
				new TimeInterval(Time.valueOf(LocalTime.of(10, 0)),Time.valueOf(LocalTime.of(12, 0))),
				new TimeInterval(Time.valueOf(LocalTime.of(13, 0)), Time.valueOf(LocalTime.of(16, 30)))
		);
		DailyHours saturday2 = new DailyHours(
				DayOfWeek.SATURDAY,
				new TimeInterval(Time.valueOf(LocalTime.of(10, 0)),Time.valueOf(LocalTime.of(11, 0))),
				null
		);
		DailyHours sunday2 = new DailyHours(
				DayOfWeek.SUNDAY,
				null,
				new TimeInterval(Time.valueOf(LocalTime.of(13, 0)), Time.valueOf(LocalTime.of(18, 0)))
		);

		WeeklyHours winterHours = new WeeklyHours();
		winterHours.setMonday(monday2);
		winterHours.setTuesday(tuesday2);
		winterHours.setWednesday(wednesday2);
		winterHours.setThursday(thursday2);
		winterHours.setFriday(friday2);
		winterHours.setSaturday(saturday2);
		winterHours.setSunday(sunday2);
		winterHours.setUserIdentifier("winter hours");

		hoursService.save(winterHours);
	}
}