package org.example.helper;

import jakarta.ws.rs.ext.*;
import org.example.dto.EmployeeDTO;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
public class EmployeeDTOConverterProvider implements ParamConverterProvider {


    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
        if(rawType.getName().equals(EmployeeDTO.class.getName())) {
            return new EmployeeIdParamConverter();
        }
        return null;
    }


    public class EmployeeIdParamConverter implements ParamConverter {

        @Override
        public Object fromString(String value) {

            EmployeeDTO employee_id = new EmployeeDTO();
            employee_id.setDeptCode(value.substring(0, 2));
            employee_id.setIdSequence(Integer.parseInt(value.substring(2, 6)));
            employee_id.setHireYear(Integer.parseInt(value.substring(6)));

            return employee_id;
        }

        @Override
        public String toString(Object value) {
            return value.toString();
        }
    }

}