package br.com.magacomunication.repository;

import br.com.magacomunication.model.Communication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunicationRepository extends PagingAndSortingRepository<Communication, Integer>, JpaRepository<Communication, Integer> {
}
