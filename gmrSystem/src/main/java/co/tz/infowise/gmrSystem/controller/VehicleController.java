package co.tz.infowise.gmrSystem.controller;

import co.tz.infowise.gmrSystem.entity.Guard;
import co.tz.infowise.gmrSystem.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/storeVehicle")
    public String storeGuard(@RequestParam("plateNumber")String plateNumber, @RequestParam("make")String make, @RequestParam("color")String color,
                             @RequestParam("timeIn") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime timeIn,
                             @RequestParam("timeOut") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime timeOut,@RequestParam("guard") Guard guard_id){
        vehicleService.saveVehicle(plateNumber,make,color,timeIn,timeOut,guard_id);
        return "redirect:/index";
    }

    @RequestMapping("/deleteVehicle/{id}")
    public String deleteVehicle(@PathVariable("id")Long id){
        vehicleService.deleteVehicle(id);
        return "redirect:/index";
    }

    @RequestMapping("/updateVehicle/{id}")
    public String updateVehicle(@PathVariable("id")Long id, @RequestParam("plateNumber")String plateNumber, @RequestParam("make")String make, @RequestParam("color")String color,
                                @RequestParam("timeIn") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime timeIn,
                                @RequestParam("timeOut") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime timeOut){
        vehicleService.updateVehicle(id,plateNumber,make,color,timeIn,timeOut);

        return "redirect:/index";
    }





}
