package co.tz.infowise.gmrSystem.controller;

import co.tz.infowise.gmrSystem.entity.Guard;
import co.tz.infowise.gmrSystem.entity.Vehicle;
import co.tz.infowise.gmrSystem.service.GuardService;
import co.tz.infowise.gmrSystem.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Controller
public class GuardController {
    @Autowired
    private GuardService guardService;

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping("/index")
    public String homePage(ModelMap modelMap) {

        List<Vehicle> vehicles = vehicleService.retrieveVehicles();
        List<Guard> guards = guardService.retrieveGuards();
        modelMap.addAttribute("vehicles", vehicles);
        modelMap.addAttribute("guards", guards);

        return "index";
    }

    @PostMapping("/storeGuard")
    public String storeGuard(@RequestParam("name")String name, @RequestParam("dateOfBirth") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfBirth){
        guardService.saveGuard(name,dateOfBirth);
        return "redirect:/index";
    }

//    @GetMapping("/searchGuard")
//    public String searchGuard(@RequestParam("search")String search,ModelMap modelMap){
//        List<Guard> guards=guardService.searchGuard(search);
//        modelMap.addAttribute("guards", guards);
//        return "index";
//    }

    @RequestMapping("/deleteGuard/{id}")
    public String deleteGuard(@PathVariable("id")Long id){
         guardService.deleteGuard(id);
        return "redirect:/index";
    }

    @RequestMapping("/showGuard/{id}")
    public String showGuard(@PathVariable("id")int id,ModelMap modelMap){
        Guard guard=guardService.showGuard(id);
        modelMap.addAttribute("guard", guard);
        return "viewGuards";
    }

    @RequestMapping("/updateGuard/{id}")
    public String editGuard(@PathVariable("id")int id,@RequestParam("name")String name,
                            @RequestParam("dateOfBirth") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfBirth){

        guardService.updateGuard(id,name,dateOfBirth);
        return "redirect:/index";
    }

}
