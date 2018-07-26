package io.github.cr9c.hello.service;

import io.github.cr9c.hello.query.PageResult;
import io.github.cr9c.hello.query.QueryObject;

public interface IEmployeeService {
	PageResult query(QueryObject qo);
}
