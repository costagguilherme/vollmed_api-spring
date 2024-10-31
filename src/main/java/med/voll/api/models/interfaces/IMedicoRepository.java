package med.voll.api.models.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.models.Medico;

public interface IMedicoRepository extends JpaRepository<Medico, Long> {
    
}
