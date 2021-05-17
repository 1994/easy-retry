package com.alibaba.easyretry.extension.spring.aop;

import com.alibaba.easyretry.common.EasyRetryPredicate;
import java.lang.reflect.Method;
import java.util.Objects;
import lombok.Data;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author Created by wuhao on 2021/3/18.
 */
@Data
public class SPELParamPredicate implements EasyRetryPredicate<Object[], String> {

	private static DefaultParameterNameDiscoverer discoverer = new DefaultParameterNameDiscoverer();

	private String bizIdCondition;

	private Method method;

	public SPELParamPredicate(String bizIdCondition, Method method) {
		this.bizIdCondition = bizIdCondition;
		this.method = method;
	}

	public SPELParamPredicate() {
	}


	@Override
	public String apply(Object[] params) {
		ExpressionParser parser = new SpelExpressionParser();
		StandardEvaluationContext context = new StandardEvaluationContext();
		String[] paramNameArr = discoverer.getParameterNames(method);
		if (Objects.isNull(paramNameArr) || paramNameArr.length == 0) {
			return null;
		}
		for (int i = 0; i < paramNameArr.length; i++) {
			context.setVariable(paramNameArr[i], params[i]);
		}
		return parser.parseExpression(bizIdCondition).getValue(context, String.class);
	}
}
