package agencia.inmobiliaria.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agencia.inmobiliaria.Repository.EntitiesDTO.InmuebleDTO;
import agencia.inmobiliaria.Service.InmuebleService;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/inmuebles")
public class InmuebleController {
 
    
        @Autowired
    private InmuebleService inmuebleService;
    
    @GetMapping("/")
    public List<InmuebleDTO> findAll() {
        return inmuebleService.findAll();
    }

    @GetMapping("/inmueblePorAlquilerOVenta")
    public List<InmuebleDTO> getInmuebleByAlquilerOrVenta() {
        return inmuebleService.getInmuebleByAlquilerOrVenta();
    }

    @GetMapping("/buscarPorNumeroReferencia/{numeroReferencia}")
    public InmuebleDTO findInmuebleByNumeroReferencia(@PathVariable Long numeroReferencia) {
        return inmuebleService.findInmuebleByNumeroReferencia(numeroReferencia);
    }


    @PostMapping("/")
    public ResponseEntity<Map<String, Object>> save(@Validated @RequestBody InmuebleDTO inmuebleDTO, BindingResult result) {
        Map<String, Object> response = new HashMap<>();

        try {

            if (result.hasErrors()) {
                List<String> errors = result.getFieldErrors()
                        .stream()
                        .map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
                        .collect(Collectors.toList());
                response.put("errors", errors);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

            InmuebleDTO inmuebleSave = null;
            inmuebleSave= inmuebleService.save(inmuebleDTO);

            response.put("mensaje", "El inmueble ha sido creado con éxito");
            response.put("Inmueble", inmuebleSave);

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el guardado en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable Long id, @Validated @RequestBody InmuebleDTO inmuebleDTO, BindingResult result) {

        Map<String, Object> response = new HashMap<>();

        try {

            if (result.hasErrors()) {
                List<String> errors = result.getFieldErrors()
                        .stream()
                        .map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
                        .collect(Collectors.toList());
                response.put("errors", errors);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

            InmuebleDTO oficinaUpdate = null;
            oficinaUpdate = inmuebleService.update(id, inmuebleDTO);

            response.put("mensaje", "El inmueble ha sido actualizado con éxito");
            response.put("Inmueble", oficinaUpdate);

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el update en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        inmuebleService.deleteById(id);
    } 
}
