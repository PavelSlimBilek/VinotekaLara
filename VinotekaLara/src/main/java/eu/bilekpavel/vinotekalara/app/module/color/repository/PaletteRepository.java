package eu.bilekpavel.vinotekalara.app.module.color.repository;

import eu.bilekpavel.vinotekalara.app.module.color.model.Palette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaletteRepository extends JpaRepository<Palette, Integer> {

}
