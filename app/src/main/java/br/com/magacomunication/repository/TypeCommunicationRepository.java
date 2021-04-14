package br.com.magacomunication.repository;

import br.com.magacomunication.model.TypeCommunication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeCommunicationRepository extends PagingAndSortingRepository<TypeCommunication, Integer>, JpaRepository<TypeCommunication, Integer> {
    Optional<TypeCommunication> findByName(String name);
}
