package co.tz.infowise.gmrSystem.service;

import co.tz.infowise.gmrSystem.entity.Guard;
import co.tz.infowise.gmrSystem.entity.Vehicle;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public interface VehicleService {

    void saveVehicle(String plateNumber, String make, String color, LocalDateTime timeIn, LocalDateTime timeOut, Guard guard_id);
    List<Vehicle> retrieveVehicles();
    void deleteVehicle(Long id);
    void updateVehicle(Long id,String plateNumber, String make, String color, LocalDateTime timeIn, LocalDateTime timeOut);




}
