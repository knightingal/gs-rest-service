package hello;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    @Select("select " +
            "emp_no as empNo, birth_date as birthDate, first_name as firstName, last_name as lastName, gender as gender, hire_date as hireDate " +
            "from employees " +
            "where emp_no < #{empNo}")
    List<Employee> queryEmployee(@Param("empNo") int empNo);
}
