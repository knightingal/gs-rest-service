package hello;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeBySessionDao {
    @Autowired
    private SqlSession sqlSession;


    public List<Employee> selectEmployees(Employee employee) {
        return this.sqlSession.selectList("selectEmployeesBySession", employee);
    }
}
