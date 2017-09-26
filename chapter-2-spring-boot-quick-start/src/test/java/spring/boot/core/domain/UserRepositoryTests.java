package spring.boot.core.domain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    UserRepository userRepository;

    /**
     * 单元测试 - 新增用户
     */
    @Test
    public void testSave() {
        User user = new User();
        user.setName("mumu");
        user.setAge(2);
//        user.setBirthday(new Date());
        user = userRepository.save(user);

        // 验证新增用户
        Assert.assertNotNull(user.getId());
    }

    /**
     * 单元测试 - 删除用户
     */
    @Test
    public void testDelete() {

        // 新增两个用户数据
        User mumu = new User();
        mumu.setName("mumu");
        mumu.setAge(2);
//        mumu.setBirthday(new Date());
        userRepository.save(mumu);

        User zizi = new User();
        zizi.setName("zizi");
        zizi.setAge(25);
//        zizi.setBirthday(new Date());
        userRepository.save(zizi);

        // 验证是否获取的用户列表大小是 2
        Assert.assertEquals(2, userRepository.findAll().size());

        // 删除用户
        userRepository.delete(mumu);

        // 验证是否获取的用户列表大小是 1
        Assert.assertEquals(1, userRepository.findAll().size());
    }

    /**
     * 单元测试 - 更新用户
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setName("mumu");
        user.setAge(2);
//        user.setBirthday(new Date());
        user = userRepository.save(user);

        user.setName("zizi");
        user = userRepository.save(user);

        // 验证新增用户的编号是否为 1
        Assert.assertNotNull(user.getId());
        Assert.assertEquals("zizi", user.getName());
    }

    /**
     * 单元测试 - 获取用户列表
     */
    @Test
    public void testFindAll() {
        // 新增两个用户数据
        User mumu = new User();
        mumu.setName("mumu");
        mumu.setAge(2);
//        mumu.setBirthday(new Date());
        userRepository.save(mumu);

        User zizi = new User();
        zizi.setName("zizi");
        zizi.setAge(25);
//        zizi.setBirthday(new Date());
        userRepository.save(zizi);

        // 验证是否获取的用户列表大小是 2
        Assert.assertEquals(2, userRepository.findAll().size());
    }

    /**
     * 单元测试 - 获取单个用户
     */
    @Test
    public void testFindById() {
        // 新增用户
        User mumu = new User();
        mumu.setName("mumu");
        mumu.setAge(2);
//        mumu.setBirthday(new Date());
        userRepository.save(mumu);

        // 验证是否获取的用户是否是插入的用户
        User expected = userRepository.findById(1L).get();
        Assert.assertEquals("mumu", expected.getName());
    }


}
