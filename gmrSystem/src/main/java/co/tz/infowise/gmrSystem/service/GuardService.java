package co.tz.infowise.gmrSystem.service;

import co.tz.infowise.gmrSystem.entity.Guard;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public interface GuardService {

    void saveGuard(String name, LocalDate dateOfBirth);
    List<Guard> retrieveGuards();
    void deleteGuard(Long id);
    Guard showGuard(int id);
    void updateGuard(int id, String name, LocalDate dateOfBirth);


//    List<Guard> searchGuard(String search);

}
