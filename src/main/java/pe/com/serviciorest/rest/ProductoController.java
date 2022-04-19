package pe.com.serviciorest.rest;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.serviciorest.entity.Producto;
import pe.com.serviciorest.service.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> findAll() {

        return productoService.findAll();
    }

    @PostMapping
    public Producto add(@RequestBody Producto c) {
        return productoService.add(c);
    }

    @GetMapping("/{id}")
    public Optional<Producto> findById(@PathVariable long id) {
        return productoService.findById(id);
    }

    @PutMapping("/{id}")
    public Producto update(@PathVariable long id, @RequestBody Producto p) {
        p.setCodigo(id);
        return productoService.update(p);
    }

    @DeleteMapping("/{id}")
    public Producto delete(@PathVariable long id) {
        Producto objproducto = new Producto();
        objproducto.setCodigo(id);
        return productoService.delete(Producto.builder().codigo(id).build());
    }
}
