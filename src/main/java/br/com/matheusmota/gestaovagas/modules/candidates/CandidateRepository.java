package br.com.matheusmota.gestaovagas.modules.candidates;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID>{
    /*
     * SELECT *
     * FROM candidato
     * WHERE username = ...
     * AND email = ...
     */
    Optional<CandidateEntity> findByUsernameOrEmail(String username, String email);
}
