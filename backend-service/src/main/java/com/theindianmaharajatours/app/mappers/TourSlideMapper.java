package com.theindianmaharajatours.app.mappers;

import com.generated.code.model.TourSlide;
import com.theindianmaharajatours.app.dao.entities.TourSlideEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TourSlideMapper {
    TourSlideMapper INSTANCE = Mappers.getMapper(TourSlideMapper.class);
    TourSlide tourSlideEntityToTourSlide(TourSlideEntity tourSlideEntity);
    List<TourSlide> getTourSlides(List<TourSlideEntity> tourSlideEntities);
}
