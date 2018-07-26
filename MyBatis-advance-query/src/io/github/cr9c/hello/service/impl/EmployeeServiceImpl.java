package io.github.cr9c.hello.service.impl;

import java.util.Collections;
import java.util.List;

import io.github.cr9c.hello.domain.Employee;
import io.github.cr9c.hello.mapper.EmployeeMapper;
import io.github.cr9c.hello.query.PageResult;
import io.github.cr9c.hello.query.QueryObject;
import io.github.cr9c.hello.service.IEmployeeService;
import io.github.cr9c.util.MyBatisUtil;

public class EmployeeServiceImpl implements IEmployeeService {

	private EmployeeMapper employeeMapper = MyBatisUtil.getMapper(EmployeeMapper.class);

	public PageResult query(QueryObject qo) {
		int rows = employeeMapper.queryForCount(qo);
		if (rows == 0) {
			return new PageResult(Collections.EMPTY_LIST, 0, 1, qo.getPageSize());
		}
		List<Employee> result = employeeMapper.queryForList(qo);
		return new PageResult(result, rows, qo.getCurrentPage(), qo.getPageSize());
	}

}
