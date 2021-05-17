package com.alibaba.easyretry.mybatis;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.alibaba.easyretry.extension.mybatis.dao.RetryTaskDAO;
import com.alibaba.easyretry.mybatis.conifg.EasyRetryMybatisProperties;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ApplicationTest.class)
class MybatisAutoConfigurationTest {

	@Resource
	private SqlSessionFactory easyRetrySqlSessionFactory;

	@Resource
	private RetryTaskDAO retryTaskDAO;

	@Autowired
	private EasyRetryMybatisProperties properties;

	@Resource
	private DemoService demoService;

	@Test
	void base() {
		assertNotNull(easyRetrySqlSessionFactory);
		assertNotNull(retryTaskDAO);
		assertThrows(UnsupportedOperationException.class, () -> demoService.throwException(1));
	}
}
