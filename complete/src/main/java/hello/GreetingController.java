package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
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
    private EmployeeMapperByAnnotation employeeMapperByAnnotation;

    @Autowired
    private EmployeeByMapperClassDao employeeByMapperClassDao;

    @Autowired
    private EmployeeBySessionDao employeeBySessionDao;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {

//        List<Employee> employeeList = employeeMapperByAnnotation.queryEmployee(10010);
        Employee condition = new Employee(10010, null, null, null, null,null);
        List<Employee> employeeList = new ArrayList<>();
        List<Employee> employeeListBySession = employeeBySessionDao.selectEmployees(condition);
        employeeList.addAll(employeeListBySession);
        condition.setEmpNo(10011);
        List<Employee> employeeListByMapperClass = employeeByMapperClassDao.selectEmployeesByMapperClass(condition);
        employeeList.addAll(employeeListByMapperClass);

        List<Employee> employeeListByAnnotation = employeeMapperByAnnotation.queryEmployee(10012);
        employeeList.addAll(employeeListByAnnotation);


        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name, myBean.getValue()), employeeList);
    }
}
