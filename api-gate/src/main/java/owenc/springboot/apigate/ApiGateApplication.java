package owenc.springboot.apigate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cowenc.springboot.apigate.dao")
public class ApiGateApplication {

    public static void main(String[] args) {

        SpringApplication.run(ApiGateApplication.class, args);
    }

}
