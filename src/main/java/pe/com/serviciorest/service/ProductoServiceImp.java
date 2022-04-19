package pe.com.serviciorest.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.serviciorest.entity.Producto;
import pe.com.serviciorest.repositorio.ProductoRepository;

@Service
public class ProductoServiceImp implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {

        return productoRepository.findAllCustom();
    }

    @Override
    public Optional<Producto> findById(long id) {

        return productoRepository.findById(id);
    }

    @Override
    public List<Producto> findByName(String name) {

        return productoRepository.findByName(name);
    }

    @Override
    public Producto add(Producto p) {

        return productoRepository.save(p);
    }

    @Override
    public Producto update(Producto p) {

        Producto objProducto = productoRepository.getById(p.getCodigo());
        BeanUtils.copyProperties(p, objProducto);

        return productoRepository.save(objProducto);
    }

    @Override
    public Producto delete(Producto p) {

        Producto objProducto = productoRepository.getById(p.getCodigo());
        objProducto.setEstado(false);

        return productoRepository.save(objProducto);
    }

}
