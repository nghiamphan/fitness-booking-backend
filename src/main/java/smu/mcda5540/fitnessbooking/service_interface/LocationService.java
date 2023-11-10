package smu.mcda5540.fitnessbooking.service_interface;

import smu.mcda5540.fitnessbooking.entity.Location;

import java.util.List;

public interface LocationService {
    List<Location> getLocations() throws Exception;

    Location getLocation(int locationId) throws Exception;

    int createLocation(Location createdLocation) throws Exception;

    Location updateLocation(int locationId, Location updatedLocation) throws Exception;

    Location deleteLocation(int locationId) throws Exception;
}