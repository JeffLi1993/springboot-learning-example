package cn.ictgu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

/**
 * Created by Silence on 2017/4/20.
 */
@SpringBootApplication
@EnableWebSocket
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
