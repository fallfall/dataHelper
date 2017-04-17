package DbBase;
import java.awt.List;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Map;

import org.omg.CORBA.TRANSACTION_MODE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Unit.City;
import Unit.Train;
import Util.Function;

public class DButils {

	/**
	 * @author linqiuping
	 */
	

	private static JdbcTemplate jdbctemplate=null;
	private static  FileSystemXmlApplicationContext context=null;
	public DButils() {
		context =new FileSystemXmlApplicationContext("src/main/resources/drds.xml");
		jdbctemplate=(JdbcTemplate) context.getBean("jdbctemplate");
	
	}
	
	public static void main(String[] args) {
		context =new FileSystemXmlApplicationContext("src/main/resources/drds.xml");
		jdbctemplate=(JdbcTemplate) context.getBean("jdbctemplate");
		DButils dButils = new DButils();
		Train train =new Train();
		train.setStart_city_id(1);
		train.setLishiValue(1);
		train.setEnd_city_id(1);
		train.setStart_station_name("hhhh");
		train.setTrain_no("00000");
		train.setEnd_station_name("111");
		dButils.add(train);
	
	}
	
	public  City  getCity(String cityName) {
		String sql=String.format("select * from  City_tb where  cityName=?");
		java.util.List<Map<String, Object>> aList=jdbctemplate.queryForList(sql,new Object[]{cityName});
		Function.println(aList.toString());
		return null;
	}

	public void add(String name,String no) {
		String sql=String.format("insert into  City_tb (cityName,cityNo) values (?,?)");
		jdbctemplate.update(sql,new Object[]{name,no});
	}
	
	public void add(Train train) {
		String sql=String.format("insert into  Train_tb (start_city_id,end_city_id,time,endStation,startStation,train) values (?,?,?,?,?,?)");
		jdbctemplate.update(sql,new Object[]{train.getStart_city_id(),train.getEnd_city_id(),train.getLishiValue(),train.getEnd_station_name(),train.getStart_station_name(),train.getTrain_no()});
	}

}
