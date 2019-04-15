package spring.boot.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.boot.core.domain.User;
import spring.boot.core.domain.UserRepository;

@SpringBootApplication
public class ValidatingFormInputApplication implements CommandLineRunner {


    private Logger LOG = LoggerFactory.getLogger(ValidatingFormInputApplication.class);

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(ValidatingFormInputApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("Sergey", 24, "1994-01-01");
        User user2 = new User("Ivan", 26, "1994-01-01");
        User user3 = new User("Adam", 31, "1994-01-01");
        LOG.info("Inserting data in DB.");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        LOG.info("User count in DB: {}", userRepository.count());
        LOG.info("User with ID 1: {}", userRepository.findById(1L));
        LOG.info("Deleting user with ID 2L form DB.");
        userRepository.deleteById(2L);
        LOG.info("User count in DB: {}", userRepository.count());
    }
}
