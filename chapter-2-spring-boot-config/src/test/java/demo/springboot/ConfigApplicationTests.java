package demo.springboot;

import demo.springboot.config.BookComponent;
import demo.springboot.config.BookProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigApplicationTests {

	@Autowired
	BookProperties bookProperties;

	@Autowired
	BookComponent bookComponent;

	@Test
	public void testBookProperties() {
		Assert.assertEquals(bookProperties.getName(),"[Spring Boot 2.x Core Action]");
		Assert.assertEquals(bookProperties.getWriter(),"BYSocket");
	}

	@Test
	public void testBookComponent() {
		Assert.assertEquals(bookComponent.getName(),"[Spring Boot 2.x Core Action]");
		Assert.assertEquals(bookComponent.getWriter(),"BYSocket");
	}
}
