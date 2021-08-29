package co.tz.infowise.gmrSystem.service;

import co.tz.infowise.gmrSystem.entity.Guard;
import co.tz.infowise.gmrSystem.entity.Vehicle;
import co.tz.infowise.gmrSystem.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService{
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public void saveVehicle(String plateNumber, String make, String color, LocalDateTime timeIn, LocalDateTime timeOut, Guard guard_id) {
        Vehicle vehicle=new Vehicle();
        vehicle.setPlateNumber(plateNumber);
        vehicle.setMake(make);
        vehicle.setColor(color);
        vehicle.setTimeIn(timeIn);
        vehicle.setTimeOut(timeOut);
        vehicle.setGuard(guard_id);
        vehicleRepository.save(vehicle);

    }

    @Override
    public List<Vehicle> retrieveVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public void updateVehicle(Long id, String plateNumber, String make, String color, LocalDateTime timeIn, LocalDateTime timeOut) {
        Vehicle vehicle= vehicleRepository.getById(id);
        vehicle.setPlateNumber(plateNumber);
        vehicle.setMake(make);
        vehicle.setColor(color);
        vehicle.setTimeIn(timeIn);
        vehicle.setTimeOut(timeOut);
        vehicleRepository.save(vehicle);

    }
}
