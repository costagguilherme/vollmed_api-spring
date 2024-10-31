package med.voll.api.dtos;

public record EnderecoDto(
    String logradouro,
    String bairro,
    String cep,
    String cidade,
    String uf,
    String complemento,
    String numero
) {}
