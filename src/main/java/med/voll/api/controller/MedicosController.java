package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.dtos.MedicoDto;
import med.voll.api.models.Medico;
import med.voll.api.models.interfaces.IMedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicosController {

    @Autowired
    private IMedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public String create(@RequestBody @Valid MedicoDto data) {
        Medico medico = new Medico(data);
        this.medicoRepository.save(medico);
        System.out.println(data);
        return "Hello Word";
    }

}