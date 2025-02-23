package rut.miit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rut.miit.models.entities.Role;
import rut.miit.models.enums.UserRoles;
import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<Role, String> {

    Optional<Role> findRoleByName(UserRoles role);
}
