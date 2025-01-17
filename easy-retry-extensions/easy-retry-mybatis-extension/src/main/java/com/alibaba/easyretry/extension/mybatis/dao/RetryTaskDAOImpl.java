package com.alibaba.easyretry.extension.mybatis.dao;

import com.alibaba.easyretry.extension.mybatis.po.RetryTaskPO;
import com.alibaba.easyretry.extension.mybatis.query.RetryTaskQuery;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author Created by wuhao on 2020/11/8.
 */
public class RetryTaskDAOImpl extends BaseDAOSupport implements RetryTaskDAO {

	public RetryTaskDAOImpl(SqlSessionFactory sqlSessionFactory) {
		super(sqlSessionFactory);
	}

	@Override
	public boolean saveRetryTask(RetryTaskPO retryTaskPO) {
		return execute(
			sqlSession ->
				sqlSession.insert("com.alibaba.easyretry.extension.mybatis.dao.RetryTaskDAO.saveRetryTask", retryTaskPO) > 0
			, true);
	}

	@Override
	public List<RetryTaskPO> listRetryTask(RetryTaskQuery retryTaskQuery) {
		return execute(sqlSession ->
			sqlSession.selectList(
				"com.alibaba.easyretry.extension.mybatis.dao.RetryTaskDAO.listRetryTask",
				retryTaskQuery)
		);
	}

	@Override
	public boolean updateRetryTask(RetryTaskPO retryTaskPO) {
		return execute(sqlSession ->
				sqlSession.update(
					"com.alibaba.easyretry.extension.mybatis.dao.RetryTaskDAO.updateRetryTask",
					retryTaskPO)
					> 0
			, true);
	}

	@Override
	public boolean deleteRetryTask(RetryTaskPO retryTaskPO) {
		return execute(sqlSession ->
				sqlSession.delete(
					"com.alibaba.easyretry.extension.mybatis.dao.RetryTaskDAO.deleteRetryTask",
					retryTaskPO)
					> 0
			, true);
	}
}
