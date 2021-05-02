package com.theindianmaharajatours.app.services;

import com.theindianmaharajatours.app.dao.entities.State;
import com.theindianmaharajatours.app.dao.repository.StateRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StateService {
    private final StateRepository stateRepository;

    StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public void addState(State state) {
        this.stateRepository.save(state);
    }

    public void updateState(State state) {
        this.stateRepository.save(state);
    }

    public List<State> getAllStates() {
        return this.stateRepository.findAll();
    }

    public State getStateById(long id) {
        return this.stateRepository.getOne(id);
    }

    public void removeState(long id) {
        this.stateRepository.delete(getStateById(id));
    }

}
