package hello;

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
    private EmployeeMapper employeeMapper;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {

        List<Employee> employeeList = employeeMapper.queryEmployee(10010);
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name, myBean.getValue()), employeeList);
    }
}
