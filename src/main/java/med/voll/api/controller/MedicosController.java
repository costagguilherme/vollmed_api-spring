package med.voll.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.common.lang.Nullable;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dtos.MedicoDto;
import med.voll.api.dtos.MedicoGetResponseDto;
import med.voll.api.dtos.MedicoPutDto;
import med.voll.api.models.Medico;
import med.voll.api.models.interfaces.IMedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicosController extends BaseController {

    @Autowired
    private IMedicoRepository medicoRepository;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid MedicoDto data) {
        Medico medico = new Medico(data);
        var savedMedico = this.medicoRepository.save(medico);
        return ResponseEntity.ok(savedMedico);
    }

    @GetMapping
    public ResponseEntity<Page<MedicoGetResponseDto>> get(@PageableDefault(size=10) Pageable pagination) {
        Page<Medico> medicos = this.medicoRepository.findAllByAtivoTrue(pagination);
        
        var result = medicos.map(medico -> new MedicoGetResponseDto(
            medico.getId(),
            medico.getNome(),
            medico.getEmail(),
            medico.getCrm(),
            medico.getAtivo(),
            medico.getEspecialidade()
        ));

        return ResponseEntity.ok(result);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Medico> update(@RequestBody @Valid MedicoPutDto data) {
        Medico medico = this.medicoRepository.findById(data.id()).orElse(null);
        
        if (medico == null) {
            return (ResponseEntity<Medico>) this.errorResponse(HttpStatus.NOT_FOUND, "Médico não encontrado");
        }

        medico.update(data);

        return ResponseEntity.ok(medico);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Medico> delete(@PathVariable Long id) {
        Medico medico = this.medicoRepository.findById(id).orElse(null);
        if (medico == null) {
            return (ResponseEntity<Medico>) this.errorResponse(HttpStatus.NOT_FOUND, "Médico não encontrado");
        }
        medico.makeInactive();
        return ResponseEntity.ok(medico);

    }


    
    

}
