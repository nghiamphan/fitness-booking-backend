package smu.mcda5540.fitnessbooking.repository;

import org.springframework.data.repository.CrudRepository;
import smu.mcda5540.fitnessbooking.entity.Location;

public interface LocationRepository extends CrudRepository<Location, Integer> {
}