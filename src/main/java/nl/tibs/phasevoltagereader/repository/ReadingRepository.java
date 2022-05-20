package nl.tibs.phasevoltagereader.repository;

import nl.tibs.phasevoltagereader.entity.ReadingEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ReadingRepository extends CrudRepository<ReadingEntity, UUID> {
}
