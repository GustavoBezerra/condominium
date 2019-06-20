package br.com.condominium.repository;

import br.com.condominium.model.entity.Resident;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentRepository extends MongoRepository<Resident, String> {
}
