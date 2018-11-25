package hello;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!, %s";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private MyBean myBean;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        List<Map<String, Object>> retList = jdbcTemplate.queryForList(
            "select " +
                "emp_no as empNo, " +
                "birth_date as birthDate, " +
                "first_name as firstName, " +
                "last_name as lastName, " +
                "gender as gender, " +
                "hire_date as hireDate " +
                "from " +
                "employees where emp_no < 10010");

        List<Employee> employeeList = new ArrayList<>();
        for (Map<String, Object> ret: retList) {
            employeeList.add(new Employee(
                    (Integer) ret.get("empNo"),
                    (Date) ret.get("birthDate"),
                    (String) ret.get("firstName"),
                    (String) ret.get("lastName"),
                    (String) ret.get("gender"),
                    (Date) ret.get("hireDate")
            ));
        }

        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name, myBean.getValue()), retList, employeeList);
    }
}
