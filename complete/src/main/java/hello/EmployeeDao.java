package hello;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDao {
    private final SqlSession sqlSession;

    public EmployeeDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<Employee> selectEmployees(int seqNo) {
        return this.sqlSession.selectList("selectEmployees", seqNo);
    }
}
