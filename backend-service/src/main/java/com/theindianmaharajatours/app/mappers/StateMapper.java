package com.theindianmaharajatours.app.mappers;

import com.generated.code.model.State;
import com.theindianmaharajatours.app.dao.entities.StateEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StateMapper {
    StateMapper INSTANCE = Mappers.getMapper(StateMapper.class);
    @Mapping(source = "stateId", target = "id")
    State stateEntityToState(StateEntity stateEntity);
    List<State> getStates(List<StateEntity> stateEntities);
}
