package pe.com.serviciorest.rest;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.serviciorest.entity.Cliente;
import pe.com.serviciorest.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping
    public List<Cliente> findAll(){
        return clienteService.findAll();
    }
    
    @PostMapping
    public Cliente add(@RequestBody Cliente c){
        return clienteService.add(c);
    }
    
    @GetMapping("/{id}")
    public Optional<Cliente> findById(@PathVariable long id){
        return clienteService.findById(id);
    }
    
    @PutMapping("/{id}")
    public Cliente update(@PathVariable long id, @RequestBody Cliente c){
        c.setCodigo(id);
        return clienteService.update(c);
    }
    
    @DeleteMapping("/{id}")
    public Cliente delete(@PathVariable long id){
        Cliente objcliente = new Cliente();
        objcliente.setCodigo(id);
        
        return clienteService.delete(Cliente.builder().codigo(id).build());
    }
}
