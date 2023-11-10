package smu.mcda5540.fitnessbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smu.mcda5540.fitnessbooking.entity.Location;
import smu.mcda5540.fitnessbooking.service_interface.LocationService;

import java.util.List;

@RequestMapping(value = "/data/locations")
@CrossOrigin
@RestController
public class LocationController {
    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Location>> getLocations() throws Exception {
        List<Location> locations = locationService.getLocations();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @GetMapping(value = "/{locationId}")
    public ResponseEntity<Location> getLocation(@PathVariable int locationId) throws Exception {
        Location location = locationService.getLocation(locationId);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<Integer> createLocation(@RequestBody Location createdLocation) throws Exception {
        int locationId = locationService.createLocation(createdLocation);
        return new ResponseEntity<>(locationId, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{locationId}")
    public ResponseEntity<Location> updateLocation(@PathVariable int locationId, @RequestBody Location updatedLocation) throws Exception {
        Location location = locationService.updateLocation(locationId, updatedLocation);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{locationId}")
    public ResponseEntity<Location> deleteLocation(@PathVariable int locationId) throws Exception {
        Location location = locationService.deleteLocation(locationId);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }
}