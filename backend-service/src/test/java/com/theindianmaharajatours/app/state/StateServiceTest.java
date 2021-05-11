package com.theindianmaharajatours.app.state;

import com.generated.code.model.State;
import com.theindianmaharajatours.app.dao.entities.StateEntity;
import com.theindianmaharajatours.app.dao.repository.StateRepository;
import com.theindianmaharajatours.app.services.StateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StateServiceTest {

    @InjectMocks
    private StateService stateService;

    @Mock
    private StateRepository stateRepository;

    @Test
    void shouldGetAllStates_whenAskedForAllStates() {
        when(stateRepository.findAll()).thenReturn(singletonList(getStateEntity()));
        List<State> allStates = stateService.getAllStates();
        Assertions.assertEquals(allStates.size(), 1);
        Assertions.assertEquals(allStates.get(0).getName(), getStateEntity().getName());
    }

    @Test
    void shouldGetStateById_whenAskedForStateById() {
        when(stateRepository.findById(1L)).thenReturn(Optional.of(getStateEntity()));
        State state = stateService.getStateById(1L);
        Assertions.assertEquals(state.getName(), getStateEntity().getName());
    }

    private StateEntity getStateEntity() {
        StateEntity state = new StateEntity();
        state.setStateId(1L);
        state.setName("Delhi");
        state.setRegion("North");
        state.setBigImageFilename("delhi.jpg");
        state.setDescriptionParagraphOne("Description one");
        state.setDescriptionParagraphTwo("Description Two");
        state.setThumbnailDescription("New Delhi");
        return state;
    }
}
