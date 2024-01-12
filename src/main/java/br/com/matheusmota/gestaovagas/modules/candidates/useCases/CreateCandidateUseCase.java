package br.com.matheusmota.gestaovagas.modules.candidates.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.matheusmota.gestaovagas.expections.UserFoundException;
import br.com.matheusmota.gestaovagas.modules.candidates.CandidateEntity;
import br.com.matheusmota.gestaovagas.modules.candidates.CandidateRepository;

@Service
public class CreateCandidateUseCase {
    
    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository
            .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
            .ifPresent((user) -> {
                throw new UserFoundException();
            });
        
        return this.candidateRepository.save(candidateEntity);
    }
}
