package com.theindianmaharajatours.app.mappers;

import com.generated.code.model.Itinerary;
import com.theindianmaharajatours.app.dao.entities.ItineraryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ItineraryMapper {
    ItineraryMapper INSTANCE = Mappers.getMapper(ItineraryMapper.class);
    List<Itinerary> getItineraries(List<ItineraryEntity> itineraryEntities);
}
