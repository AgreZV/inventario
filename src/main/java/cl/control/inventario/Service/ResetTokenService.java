package cl.control.inventario.Service;
import cl.control.inventario.Model.ResetToken;

public interface ResetTokenService {

    ResetToken findByToken(String token);

    void guardar(ResetToken token);

    void eliminar(ResetToken token);
}
