package hello;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

@Mapper
public interface EmployeeDao {


    public List<Employee> selectEmployees(Employee employee);
}
