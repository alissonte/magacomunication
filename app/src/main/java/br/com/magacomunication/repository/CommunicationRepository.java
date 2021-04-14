package br.com.magacomunication.repository;

import br.com.magacomunication.model.Communication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunicationRepository extends JpaRepository<Communication, Integer> {
}
