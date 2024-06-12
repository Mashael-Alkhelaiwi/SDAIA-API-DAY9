package org.example.mappers;

import org.example.dto.EmployeesDto;
import org.example.models.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {JobMapper.class})
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);


    EmployeesDto toEmpDto(Employee employee);

    Employee toModel(EmployeesDto dto);

}