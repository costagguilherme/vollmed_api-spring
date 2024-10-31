package med.voll.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dtos.MedicoDto;
import med.voll.api.dtos.MedicoPutDto;
import med.voll.api.enums.EspecialidadeEnum;


@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private EspecialidadeEnum especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(MedicoDto data) {
        this.nome = data.nome();
        this.email = data.email();
        this.telefone = data.telefone();
        this.crm = data.crm();
        this.ativo = true;
        this.especialidade = data.especialidade();
        this.endereco = new Endereco(data.endereco());
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void update(MedicoPutDto data) {
        this.nome = data.nome() != null ? data.nome() : this.nome;
        this.telefone = data.telefone() != null ? data.telefone() : this.telefone;
        this.endereco.update(data.endereco());
    }

    public void makeInactive() {
        this.ativo = false;
    }
}
