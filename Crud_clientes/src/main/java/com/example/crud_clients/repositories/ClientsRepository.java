package com.example.crud_clients.repositories;

import com.example.crud_clients.entities.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Clients, Long> {
}
