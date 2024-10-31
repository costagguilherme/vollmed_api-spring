package med.voll.api.dtos;

import med.voll.api.enums.EspecialidadeEnum;

public record MedicoGetResponseDto(String nome, String email, String crm, EspecialidadeEnum especialidade) {
}
