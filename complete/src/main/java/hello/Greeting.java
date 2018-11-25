package hello;

import java.util.List;
import java.util.Map;

public class Greeting {

    private final long id;
    private final String content;

    private final List<Employee> employeeList;


    private final List<Map<String, Object>> retList;
    public Greeting(long id, String content, List<Map<String, Object>> retList, List<Employee> employeeList) {
        this.id = id;
        this.content = content;

        this.retList = retList;
        this.employeeList = employeeList;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public List<Map<String, Object>> getRetList() {
        return retList;
    }

}
