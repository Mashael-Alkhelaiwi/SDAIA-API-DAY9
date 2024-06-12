package org.example.mappers;

import org.example.dto.JobDTO;
import org.example.models.Jobs;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JobMapper {

    JobMapper INSTANCE = Mappers.getMapper(JobMapper.class);


    //Get
    JobDTO toDeptDto(Jobs j);

    //Post
    Jobs toModel(JobDTO dto);
}