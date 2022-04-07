package com.example.crud_clients.services;

import com.example.crud_clients.dto.ClientsDTO;
import com.example.crud_clients.entities.Clients;
import com.example.crud_clients.repositories.ClientsRepository;
import com.example.crud_clients.services.exceptions.DataBaseException;
import com.example.crud_clients.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ClientsService {

    @Autowired
    private ClientsRepository clientsRepository;

    @Transactional(readOnly = true)
    public Page<ClientsDTO> findAllPaged(PageRequest pageRequest) {
        Page<Clients> list = clientsRepository.findAll(pageRequest);
        return list.map(x -> new ClientsDTO(x));
    }

    @Transactional(readOnly = true)
    public ClientsDTO findById(Long id) {
        Optional<Clients> obj = clientsRepository.findById(id);
        Clients entity = obj.orElseThrow(() -> new ResourceNotFoundException("Desculpe, id não encontrado!"));
        return new ClientsDTO(entity);
    }

    @Transactional
    public ClientsDTO insert(ClientsDTO dto) {
        Clients entity = new Clients();
        copyEntityDTO(entity, dto);
        entity = clientsRepository.save(entity);
        return new ClientsDTO(entity);
    }


    @Transactional
    public ClientsDTO update(Long id, ClientsDTO dto) {
        try {
            Clients entity = clientsRepository.getById(id);
            copyEntityDTO(entity, dto);
            entity = clientsRepository.save(entity);
            return new ClientsDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        try {
            clientsRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("id not found " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }

    private void copyEntityDTO(Clients entity, ClientsDTO dto) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }
}

