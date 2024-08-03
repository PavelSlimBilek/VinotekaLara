package eu.bilekpavel.vinotekalara.service;

import eu.bilekpavel.vinotekalara.dto.OpeningHours;
import eu.bilekpavel.vinotekalara.dto.OpeningHoursRequest;
import eu.bilekpavel.vinotekalara.repository.OpeningHoursRepositoryInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OpeningHoursService implements OpeningHourServiceInterface {

    private OpeningHoursRepositoryInterface repo;

    @Override
    public boolean save(OpeningHoursRequest request) {
        OpeningHours openingHours = new OpeningHours(request);
        return this.repo.save(openingHours);
    }

    @Override
    public List<OpeningHours> getOpeningHours() {
        return repo.getAll();
    }
}