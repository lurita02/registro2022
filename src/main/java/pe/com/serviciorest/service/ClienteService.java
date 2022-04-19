package pe.com.serviciorest.service;

import java.util.List;
import java.util.Optional;
import pe.com.serviciorest.entity.Cliente;

public interface ClienteService {
    
    List<Cliente> findAll();
	
    Optional<Cliente> findById(long id);
	
    List<Cliente> findByName(String name);
	
    Cliente add(Cliente c);
	
    Cliente update(Cliente c);
	
    Cliente delete(Cliente c);
}
