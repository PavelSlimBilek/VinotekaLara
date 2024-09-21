package eu.bilekpavel.vinotekalara;

import eu.bilekpavel.vinotekalara.alertbar.dto.AlertRequest;
import eu.bilekpavel.vinotekalara.alertbar.service.AlertServiceInterface;
import eu.bilekpavel.vinotekalara.translator.dto.LocalizedStringRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class VinotekaLaraApplication implements CommandLineRunner {

	private final AlertServiceInterface alertService;

	public VinotekaLaraApplication(AlertServiceInterface alertService) {
		this.alertService = alertService;
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
	}
}