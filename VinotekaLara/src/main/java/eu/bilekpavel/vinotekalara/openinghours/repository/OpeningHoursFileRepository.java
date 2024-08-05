package eu.bilekpavel.vinotekalara.openinghours.repository;

import eu.bilekpavel.vinotekalara.openinghours.domain.OpeningHours;
import eu.bilekpavel.vinotekalara.openinghours.dto.TimeInterval;
import org.springframework.stereotype.Repository;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Time;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OpeningHoursFileRepository implements OpeningHoursRepositoryInterface {
    private final Path PATH = Paths.get("src/settings/opening_hours.csv");

    @Override
    public void save(OpeningHours openingHours) throws IOException {
        if (openingHours == null) {
            return;
        }

        List<OpeningHours> currentHours = getAll();

        currentHours = currentHours.stream()
                .filter(hours -> hours.getDay() != openingHours.getDay())
                .collect(Collectors.toList());
        currentHours.add(openingHours);

        currentHours.sort(Comparator.comparingInt(hours -> hours.getDay().getValue()));

        try (BufferedWriter writer = Files.newBufferedWriter(PATH)) {
            StringBuilder sb = new StringBuilder();
            for (OpeningHours hours : currentHours) {
                sb.append(hours).append("\n"); // OpeningHours has overridden toString()
            }
            writer.write(sb.toString());
        }
    }

    @Override
    public List<OpeningHours> getAll() {
        try {
            List<String[]> values = getStringValues();
            return values.stream()
                    .map(data -> new OpeningHours(
                            DayOfWeek.of(Integer.parseInt(data[0])),
                            new TimeInterval(
                                    Time.valueOf(data[2]),
                                    Time.valueOf(data[3])
                            ),
                            data.length < 6
                                    ? null
                                    : new TimeInterval(
                                            Time.valueOf(data[4]),
                                            Time.valueOf(data[5])
                                    )
                            )
                    )
                    .sorted(Comparator.comparingInt((n) -> n.getDay().getValue()))
                    .toList();

        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private List<String[]> getStringValues() throws IOException {
        List<String> lines = Files.readAllLines(PATH);
        return lines.stream()
                .filter((line) -> !line.isEmpty() && !line.isBlank())
                .map((line) -> line.split(","))
                .collect(Collectors.toList());
    }
}