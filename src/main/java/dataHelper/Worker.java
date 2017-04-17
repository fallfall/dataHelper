package dataHelper;

import java.util.List;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

import com.google.gson.Gson;

import DbBase.DButils;
import Unit.City;
import Unit.DataBox;
import Unit.Train;
import Util.Function;

public class Worker {

	static Gson gson = new Gson();

	public static void main(String[] args) {
		 Worker worker=new Worker();
		 worker.collet();
 


		
	}
	
	public void  collet() {
		String aString = null;
		 try {
			 HttpHander httpHander=new HttpHander();
		 aString=httpHander.getTrain("2017-05-04","BJP","SHH");
		 } catch (Exception e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		//Scanner scanner = new Scanner(System.in);
		// SelectUpdate selectUpdate = (SelectUpdate)
		// txcContext.getBean("SelectUpdate", SelectUpdate.class);
	//	aString = scanner.nextLine();
		City citystart = new City();
		City cityEnd = new City();
		System.out.println(aString);
		Unit.Result result = (Unit.Result) gson.fromJson(aString, Unit.Result.class);
		List<DataBox> list = result.getData();
		DButils dButils = new DButils();
		for (DataBox dataBox : list) {
			Train train = dataBox.getQueryLeftNewDTO();
			train.setEnd_city_id(1);
			train.setStart_city_id(2);
			Function.println(train.toString());
			dButils.add(train);

		}
	}

}
