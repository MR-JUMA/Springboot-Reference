package co.tz.infowise.gmrSystem.service;

import co.tz.infowise.gmrSystem.entity.Guard;
import co.tz.infowise.gmrSystem.repository.GuardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class GuardServiceImpl implements GuardService {

    @Autowired
    private GuardRepository guardRepository;

    @Override
    public void saveGuard(String name, LocalDate dateOfBirth) {
        Guard guard =new Guard();
        guard.setName(name);
        guard.setDateOfBirth(dateOfBirth);
        guardRepository.save(guard);
    }

    @Override
    public List<Guard> retrieveGuards() {
        return guardRepository.findAll();
    }

    @Override
    public void deleteGuard(Long id) {
        guardRepository.deleteById(id);
    }

    @Override
    public Guard showGuard(int id) {
        return guardRepository.findById((long) id).orElse(null);
    }

    @Override
    public void updateGuard(int id,String name, LocalDate dateOfBirth) {
        Guard guard= guardRepository.getById((long) id);
        guard.setName(name);
        guard.setDateOfBirth(dateOfBirth);
        guardRepository.save(guard);


    }

//    @Override
//    public List<Guard> searchGuard(String search) {
//        return guardRepository.
//    }
}
