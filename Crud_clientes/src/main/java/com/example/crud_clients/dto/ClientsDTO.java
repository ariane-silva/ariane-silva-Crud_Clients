package com.example.crud_clients.dto;

import com.example.crud_clients.entities.Clients;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientsDTO {

    private Long id;
    private String name;
    private String cpf;
    private Double income;
    private Instant birthDate;
    private Integer children;

    public ClientsDTO(Clients clients) {
        this.id = clients.getId();
        this.name = clients.getName();
        this.cpf = clients.getCpf();
        this.income = clients.getIncome();
        this.birthDate = clients.getBirthDate();
        this.children = clients.getChildren();
    }
}
