package DbBase;

import java.awt.List;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Map;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import Util.Function;


public class DButils {

	/**
	 * @author linqiuping
	 */
	
	public  JdbcTemplate jdbctemplate=null;
	private  FileSystemXmlApplicationContext context=null;
	public DButils() {
		context =new FileSystemXmlApplicationContext("src/main/resources/drds.xml");
		jdbctemplate=(JdbcTemplate) context.getBean("jdbctemplate");
	
	}
	
	public static void main(String[] args) {
		DButils dButils=new DButils();
		dButils.test();
	}
	
	public void  test() {
		String sql="select * from  City_tb ";
		java.util.List<Map<String, Object>> aList=jdbctemplate.queryForList(sql);
		Function.println(aList.toString());
	}

	public void add(String name,String no) {
		String sql="";
		
	}
	

}
