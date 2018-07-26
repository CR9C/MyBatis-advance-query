用MyBatis来实现高级查询+分页:

需求:按照员工的关键字(abc),工资范围,所属部门来查询

一些小的细节:(具体情况请看代码)

- 在PageResult类中应有一个安全判断

  ```
  //这是做一个安全判断
  //如果当前页已经大于总页数了,就应该把总页数作为当前页,否则,就把当前页自己做自己.
  //比如:因为有时候是10页并且第10页只有一条数据,删掉了一条数据,就应当到第9页上去
  currentPage = currentPage > totalPage ? totalPage : currentPage;
  ```



- 为了减少代码的冗余度,将下列三个方法提取到基类.(判断字符串是否为空串,该方法平时学习用的较多)

  ```
  @Getter
  @Setter
  public class QueryObject {
  	private int currentPage = 1;
  	private int pageSize = 3;
  
  	//分页查询: LIMIT  start,pageSize
  	public int getStart() {
  		return (currentPage - 1) * pageSize;
  	}
  
  	//如果字符串为空串,也应该设置为null
  	public String empty2null(String str) {
  		return hasLength(str) ? str : null;
  	}
  
  	public boolean hasLength(String str) {
  		return str != null && !"".equals(str.trim());
  	}
  
  }
  ```

  

- 在xml文件中,小于号应表示为 &lt ;表示,大于号原样表示

  ```
  <if test="minSalary!=null">
  	AND salary >= #{minSalary}
  </if>
  <if test="maxSalary!=null">
  	AND salary &lt;= #{maxSalary}
  </if>
  ```

  

