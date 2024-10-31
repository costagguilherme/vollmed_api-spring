package med.voll.api.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record MedicoPutDto(
    @NotNull
    Long id,

    String nome,

    String telefone,

    @NotNull
    @Valid
    EnderecoDto endereco
) {
}
