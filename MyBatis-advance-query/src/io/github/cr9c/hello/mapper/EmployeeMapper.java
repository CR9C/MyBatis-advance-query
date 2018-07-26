package io.github.cr9c.hello.mapper;

import java.util.List;

import io.github.cr9c.hello.domain.Employee;
import io.github.cr9c.hello.query.QueryObject;

public interface EmployeeMapper {
	
	List<Employee> queryForList(QueryObject qo);
	
	int queryForCount(QueryObject qo);
	
	
	List<Employee> listAll();
}
