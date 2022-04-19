package pe.com.serviciorest.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.serviciorest.entity.Distrito;
import pe.com.serviciorest.repositorio.DistritoRepository;

@Service
public class DistritoServiceImp implements DistritoService{
    
    @Autowired
    private DistritoRepository distritoRespository; 
    
    @Override
    public List<Distrito> findAll() {
        
        return distritoRespository.findAllCustom();
    }

    @Override
    public Optional<Distrito> findById(long id) {

        return distritoRespository.findById(id);
    }

    @Override
    public List<Distrito> findByName(String name) {

        return distritoRespository.findByName(name);
    }

    @Override
    public Distrito add(Distrito d) {

        return distritoRespository.save(d);
    }

    @Override
    public Distrito update(Distrito d) {

        Distrito objdistrito = distritoRespository.getById(d.getCodigo());
        BeanUtils.copyProperties(d, objdistrito);
        
        return distritoRespository.save(objdistrito);
    }

    @Override
    public Distrito delete(Distrito d) {
        
        Distrito objdistrito = distritoRespository.getById(d.getCodigo());
        objdistrito.setEstado(false);
        
        return distritoRespository.save(objdistrito);
    }
    
}
