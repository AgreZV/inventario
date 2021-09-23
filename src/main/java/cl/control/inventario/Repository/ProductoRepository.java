package cl.control.inventario.Repository;

import cl.control.inventario.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    //select * from producto p where p.proveedor.idProveedor = :idProveedor;
    @Query("from Producto p where p.proveedor.idProveedor = :idProveedor")
    List<Producto> findAllByProveedor(@Param("idProveedor") Integer idProveedor);
}
