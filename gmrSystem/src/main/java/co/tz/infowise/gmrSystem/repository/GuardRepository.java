package co.tz.infowise.gmrSystem.repository;

import co.tz.infowise.gmrSystem.entity.Guard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuardRepository extends JpaRepository<Guard,Long> {

//    @Query(value = "from Guard where Guard.name LIKE '%search%'",nativeQuery = true)
//    List<Guard> searchGuard(String search);
}
