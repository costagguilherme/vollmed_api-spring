package med.voll.api.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dtos.EnderecoDto;
import med.voll.api.dtos.MedicoPutDto;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(EnderecoDto data) {
        this.logradouro = data.logradouro();
        this.bairro = data.bairro();
        this.cep = data.cep();
        this.numero = data.numero();
        this.complemento = data.complemento();
        this.cidade = data.cidade();
        this.uf = data.uf();
    }

    public void update(EnderecoDto data) {
        this.logradouro = data.logradouro() != null ? data.logradouro() : this.logradouro;
        this.bairro = data.bairro() != null ? data.bairro() : this.bairro;
        this.cep = data.cep() != null ? data.cep() : this.cep;
        this.numero = data.numero() != null ? data.numero() : this.numero;
        this.complemento = data.complemento() != null ? data.complemento() : this.complemento;
        this.cidade = data.cidade() != null ? data.cidade() : this.cidade;
        this.uf = data.uf() != null ? data.uf() : this.uf;
    }
}
