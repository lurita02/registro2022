package pe.com.serviciorest.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.serviciorest.entity.Categoria;
import pe.com.serviciorest.repositorio.CategoriaRespository;

@Service
public class CategoriaServiceImp implements CategoriaService {
	
	@Autowired
	private CategoriaRespository categoriaRespository;
	
	@Override
	public List<Categoria> findAll() {
            
            return categoriaRespository.findAllCustom();
	}

	@Override
	public Optional<Categoria> findById(long id) {

            return categoriaRespository.findById(id);
	}

	@Override
	public List<Categoria> findByName(String name) {
		
            return categoriaRespository.findByName(name);
	}

	@Override
	public Categoria add(Categoria c) {
		
            return categoriaRespository.save(c);
	}

	@Override
	public Categoria update(Categoria c) {
		
            Categoria objcategoria = categoriaRespository.getById(c.getCodigo());
            BeanUtils.copyProperties(c, objcategoria);
		
            return categoriaRespository.save(objcategoria);
	}

	@Override
	public Categoria delete(Categoria c) {
		
            Categoria objcategoria = categoriaRespository.getById(c.getCodigo());
            objcategoria.setEstado(false);
		
            return categoriaRespository.save(objcategoria);
	}
	
}

