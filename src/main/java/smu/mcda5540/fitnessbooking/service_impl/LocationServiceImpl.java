package smu.mcda5540.fitnessbooking.service_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smu.mcda5540.fitnessbooking.entity.Location;
import smu.mcda5540.fitnessbooking.repository.LocationRepository;
import smu.mcda5540.fitnessbooking.service_interface.LocationService;
import smu.mcda5540.fitnessbooking.utils.FitnessBookingException;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> getLocations() {
        Iterable<Location> iterable = locationRepository.findAll();
        List<Location> locations = new ArrayList<>();
        for (Location location : iterable) {
            locations.add(location);
        }
        return locations;
    }

    @Override
    public Location getLocation(int locationId) throws Exception {
        return locationRepository.findById(locationId).orElseThrow(() -> new FitnessBookingException("ERROR.NOT_FOUND"));
    }

    @Override
    public int createLocation(Location createdLocation) {
        return locationRepository.save(createdLocation).getId();
    }

    @Override
    public Location updateLocation(int locationId, Location updatedLocation) throws Exception {
        Location location = locationRepository.findById(locationId).orElseThrow(() -> new FitnessBookingException("ERROR.NOT_FOUND"));

        location.setDescription(updatedLocation.getDescription());
        location.setArea(location.getArea());

        return locationRepository.save(location);
    }

    @Override
    public Location deleteLocation(int locationId) throws Exception {
        Location location = locationRepository.findById(locationId).orElseThrow(() -> new FitnessBookingException("ERROR.NOT_FOUND"));
        locationRepository.deleteById(locationId);
        return location;
    }
}