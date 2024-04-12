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

import agencia.inmobiliaria.Repository.EntitiesDTO.VisitaInmuebleDTO;
import agencia.inmobiliaria.Service.VisitaInmuebleService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/visitaInmuebles")
public class VisitaInmuebleController {
       
    @Autowired
    private VisitaInmuebleService visitaInmuebleService;
    
    @GetMapping("/")
    public List<VisitaInmuebleDTO> findAll() {
        return visitaInmuebleService.findAll();
    }


    @PostMapping("/")
    public ResponseEntity<Map<String, Object>> save(@Validated @RequestBody VisitaInmuebleDTO visitaInmuebleDTO, BindingResult result) {
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

            VisitaInmuebleDTO visitaInmuebleSave = null;
            visitaInmuebleSave =  visitaInmuebleService.save(visitaInmuebleDTO);

            response.put("mensaje", "La visita inmueble ha sido creado con éxito");
            response.put("Visita inmueble", visitaInmuebleSave);

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el guardado en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable Long id, @Validated @RequestBody VisitaInmuebleDTO visitaInmuebleDTO, BindingResult result) {

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

            VisitaInmuebleDTO zonaUpdate = null;
            zonaUpdate = visitaInmuebleService.update(id, visitaInmuebleDTO);

            response.put("mensaje", "La visita inmueble ha sido actualizado con éxito");
            response.put("Visita inmueble", zonaUpdate);

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el update en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        visitaInmuebleService.deleteById(id);
    } 
}
