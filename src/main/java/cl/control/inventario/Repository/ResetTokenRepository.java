package cl.control.inventario.Repository;

import cl.control.inventario.Model.ResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResetTokenRepository extends JpaRepository<ResetToken, Integer> {

    //from ResetToken where token = :?
    ResetToken findByToken(String token);
}
