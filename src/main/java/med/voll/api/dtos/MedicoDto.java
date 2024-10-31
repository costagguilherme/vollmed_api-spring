package med.voll.api.dtos;

import med.voll.api.enums.EspecialidadeEnum;

public record MedicoDto (
    String nome,
    String email,
    String crm,
    EspecialidadeEnum especialidade ,
    EnderecoDto endereco
) {}
