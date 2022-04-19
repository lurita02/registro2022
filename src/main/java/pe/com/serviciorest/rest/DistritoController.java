package pe.com.serviciorest.rest;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.serviciorest.entity.Distrito;
import pe.com.serviciorest.service.DistritoService;

@RestController
@RequestMapping("/distrito")
public class DistritoController {

    @Autowired
    private DistritoService distritoService;

    @GetMapping
    public List<Distrito> findAll() {
        return distritoService.findAll();
    }

    @PostMapping
    public Distrito add(@RequestBody Distrito d) {
        return distritoService.add(d);
    }

    @GetMapping("/{id}")
    public Optional<Distrito> findById(@PathVariable long id) {
        return distritoService.findById(id);
    }

    @PutMapping("/{id}")
    public Distrito update(@PathVariable long id, @RequestBody Distrito d) {
        d.setCodigo(id);
        return distritoService.update(d);
    }

    @DeleteMapping("/{id}")
    public Distrito delete(@PathVariable long id) {
        Distrito objcategoria = new Distrito();
        objcategoria.setCodigo(id); 
        return distritoService.delete(Distrito.builder().codigo(id).build());
    }
}
