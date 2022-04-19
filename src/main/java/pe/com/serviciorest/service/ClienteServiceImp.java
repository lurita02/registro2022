package pe.com.serviciorest.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.serviciorest.entity.Cliente;
import pe.com.serviciorest.repositorio.ClienteRepository;

@Service
public class ClienteServiceImp implements ClienteService{
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Override
    public List<Cliente> findAll() {
        
        return clienteRepository.findAllCustom();
    }

    @Override
    public Optional<Cliente> findById(long id) {

        return clienteRepository.findById(id);
    }

    @Override
    public List<Cliente> findByName(String name) {
        
        return clienteRepository.findByName(name);
    }

    @Override
    public Cliente add(Cliente c) {
        
        return clienteRepository.save(c);
    }

    @Override
    public Cliente update(Cliente c) {

        Cliente objcliente = clienteRepository.getById(c.getCodigo());
        BeanUtils.copyProperties(c, objcliente);
        
        return clienteRepository.save(objcliente);
    }

    @Override
    public Cliente delete(Cliente c) {

        Cliente objcliente = clienteRepository.getById(c.getCodigo());
        objcliente.setEstado(false);
        
        return clienteRepository.save(objcliente);
    }
    
}
