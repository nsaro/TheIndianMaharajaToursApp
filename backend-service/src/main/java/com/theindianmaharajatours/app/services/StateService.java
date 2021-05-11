package com.theindianmaharajatours.app.services;

import com.generated.code.model.State;
import com.theindianmaharajatours.app.dao.entities.StateEntity;
import com.theindianmaharajatours.app.dao.repository.StateRepository;
import com.theindianmaharajatours.app.mappers.StateMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@Transactional
public class StateService {
    private final StateRepository stateRepository;

    StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public void addState(StateEntity stateEntity) {
        this.stateRepository.save(stateEntity);
    }

    public void updateState(StateEntity stateEntity) {
        this.stateRepository.save(stateEntity);
    }

    public List<State> getAllStates() {
        return StateMapper.INSTANCE.getStates(this.stateRepository.findAll());
    }

    public State getStateById(long id) {
        return StateMapper.INSTANCE.stateEntityToState(getStateEntityById(id));
    }

    public StateEntity getStateEntityById(long id) {
        StateEntity stateEntity = this.stateRepository.findById(id).orElse(null);
        if (stateEntity == null)
        {
            throw new ResponseStatusException(NOT_FOUND, "State not found!");
        }
        return stateEntity;
    }

    public void removeState(long id) {
        this.stateRepository.delete(getStateEntityById(id));
    }

}
