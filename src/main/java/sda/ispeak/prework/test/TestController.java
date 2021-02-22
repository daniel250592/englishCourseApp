package sda.ispeak.prework.test;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TestController {


    @GetMapping("/test")
    public TestClass getTestClass(){
        TestClass testClass = new TestClass();
        testClass.setTest("test");
        return testClass;
    }
}
