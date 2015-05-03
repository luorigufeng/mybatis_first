package com.zxj.mybatis;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.*;

import com.zxj.mybatis.mapper.UserMapper;
import com.zxj.mybatis.model.User;

public class UserTest {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	private SqlSession session;

	@BeforeClass
	public static void setUpBeforeClass() {
		try {
			reader = Resources.getResourceAsReader("mybatis-configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Before
	public void setUp() {
		this.session = sqlSessionFactory.openSession();
	}

	@Test
	public void testQueryUserById() {
		try {
			UserMapper userMapper = session.getMapper(UserMapper.class);
			User user = userMapper.selectUserByID(1);
			// User user = (User) session.selectOne(
			// "com.zxj.mybatis.mapper.UserMapper.selectUserByID", 1);
			assertThat(user.getUserAddress(), is("shanghai,pudong"));
			assertThat(user.getUserName(), is("summer"));
		} finally {
			this.session.close();
		}

	}

	@Test
	public void testQueryUserListByName() {
		try {
			UserMapper userMapper = session.getMapper(UserMapper.class);
			List<User> userList = userMapper.selectUsers("%");
			assertThat(userList.size(), is(1));
		} finally {
			this.session.close();
		}

	}

	@Test
	public void testAddUser() {
		try {
			User user = new User();
			user.setUserName("cc").setUserAge("29").setUserAddress("wanke");
			UserMapper userMapper = this.session.getMapper(UserMapper.class);
			userMapper.addUser(user);

			List<User> userList = userMapper.selectUsers("%");
			assertThat(userList.size(), is(2));
			
//			this.session.commit();
		} finally {
			this.session.close();
		}
	}
	
	@Test
	public void testUpdateUser() {
		try {
			User updateUser = new User();
			updateUser.setId(1).setUserName("cc").setUserAge("29").setUserAddress("zz");
			UserMapper userMapper = this.session.getMapper(UserMapper.class);
			userMapper.updateUser(updateUser);

			User user = userMapper.selectUserByID(1);
			assertThat(user.getUserAddress(), is("zz"));
			assertThat(user.getUserName(), is("cc"));
//			this.session.commit();
		} finally {
			this.session.close();
		}
	}
	
	public void testDeleteUser() {
		try {
			UserMapper userMapper = this.session.getMapper(UserMapper.class);
			userMapper.deleteUser(1);

			User user = userMapper.selectUserByID(1);
			Assert.assertNull(user);
//			this.session.commit();
		} finally {
			this.session.close();
		}
	}
}
