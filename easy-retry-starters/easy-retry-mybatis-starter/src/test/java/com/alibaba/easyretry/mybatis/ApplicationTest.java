package com.alibaba.easyretry.mybatis;

import com.alibaba.easyretry.extension.mybatis.DbConfig;
import javax.sql.DataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApplicationTest {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationTest.class);
	}

	@Bean
	public DataSource easyRetryMybatisDataSource() {
		return DbConfig.getDataSource();
	}
}
