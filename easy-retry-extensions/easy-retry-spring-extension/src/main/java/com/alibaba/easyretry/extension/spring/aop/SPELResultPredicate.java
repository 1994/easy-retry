package com.alibaba.easyretry.extension.spring.aop;

import com.alibaba.easyretry.common.AbstractResultPredicate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author Created by wuhao on 2021/3/18.
 */
@Getter
@Setter
@ToString(callSuper = true)
public class SPELResultPredicate<T> extends AbstractResultPredicate<T> {

	private String resultCondition;

	public SPELResultPredicate(String resultCondition) {
		this.resultCondition = resultCondition;
	}

	public SPELResultPredicate() {
	}


	@Override
	public Boolean apply(T result) {
		ExpressionParser parser = new SpelExpressionParser();
		StandardEvaluationContext context = new StandardEvaluationContext();
		context.setVariable("result", result);
		return parser.parseExpression(resultCondition).getValue(context, Boolean.class);
	}
}
