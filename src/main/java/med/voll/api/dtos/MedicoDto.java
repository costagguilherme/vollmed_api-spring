package med.voll.api.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.enums.EspecialidadeEnum;

public record MedicoDto (
    @NotBlank
    String nome,

    @NotBlank
    @Email
    String email,

    @NotBlank
    @Pattern(regexp= "\\d{4,6}")
    String crm,

    @NotNull
    EspecialidadeEnum especialidade,

    @NotNull
    @Valid
    EnderecoDto endereco
) {}
