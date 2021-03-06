package cl.control.inventario.Service.Implements;

import cl.control.inventario.Model.ResetToken;
import cl.control.inventario.Repository.ResetTokenRepository;
import cl.control.inventario.Service.ResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetTokenServiceImpl implements ResetTokenService {

    @Autowired
    private ResetTokenRepository repo;

    @Override
    public ResetToken findByToken(String token) {
        return repo.findByToken(token);
    }

    @Override
    public void guardar(ResetToken token) {
        repo.save(token);

    }

    @Override
    public void eliminar(ResetToken token) {
        repo.delete(token);
    }
}
