package eu.bilekpavel.vinotekalara.repository;

import eu.bilekpavel.vinotekalara.dto.OpeningHours;
import eu.bilekpavel.vinotekalara.dto.TimeInterval;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Time;
import java.time.DayOfWeek;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class OpeningHoursFileStorage implements OpeningHoursRepositoryInterface {
    private final File FILE = new File("src/settings/opening_hours.csv");
    private final FileWriter WRITER = new FileWriter(FILE);

    public OpeningHoursFileStorage() throws IOException {
    }

    @Override
    public boolean save(OpeningHours openingHours) {
        if (openingHours == null) {
            return false;
        }
        String line = convertToLine(openingHours);

        try {
            WRITER.write(line);
            WRITER.write(System.lineSeparator());
            WRITER.flush();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public List<OpeningHours> getAll() {
        try {
            List<String[]> separatedValues = separateValues();
            Set<OpeningHours> hours = separatedValues.stream()
                    .map(match -> new OpeningHours(
                            DayOfWeek.valueOf(match[0]),
                            new TimeInterval(
                                    Time.valueOf(match[1]),
                                    Time.valueOf(match[2])
                            )))
                    .collect(Collectors.toSet());
            return hours.stream().sorted(Comparator.comparingInt(n -> n.getDay().getValue())).collect(Collectors.toList());
        } catch (IOException e) {
            return null;
        }
    }

    private OpeningHours getByDay(String day) throws IOException {
        List<String[]> lines = separateValues();
        String[] match = lines.stream()
                .filter(line -> line[0].equals(day))
                .findFirst()
                .orElseThrow();
        return new OpeningHours(
                DayOfWeek.valueOf(match[0]),
                new TimeInterval(
                        Time.valueOf(match[1]),
                        Time.valueOf(match[2])
                ));
    }

    private List<String[]> separateValues() throws IOException {
        List<String> lines = Files.readAllLines(FILE.toPath());
        return lines.stream().map((l) -> {
                return l.split(",");
        }).collect(Collectors.toList());
    }

    private String convertToLine(OpeningHours openingHours) {
        return String.format("%s,%s,%s",
                openingHours.getDay(),
                openingHours.getHours().start(),
                openingHours.getHours().end());
    }
}