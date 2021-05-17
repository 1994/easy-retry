package com.alibaba.easyretry.mybatis;

import com.alibaba.easyretry.extension.spring.aop.EasyRetryable;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

	@EasyRetryable
	public void throwException(int i) {
		throw new UnsupportedOperationException();
	}

}
