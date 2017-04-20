package dataHelper;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

import com.google.gson.Gson;

import DbBase.DButils;
import Unit.City;
import Unit.DataBox;
import Unit.Train;
import Util.Config;
import Util.Function;

public class Worker {

 private  Gson gson = new Gson();
	private HttpHander httpHander = new HttpHander();
	private static DButils dButils = new DButils();

	public static void main(String[] args) {
		Worker worker = new Worker();
		Analysis analysis=new Analysis();
		analysis.initity();
		List<Map<String, Object>> aList=dButils.getCity();
		for (Map<String, Object> map : aList) {
			for (Map<String, Object> bmap : aList) {
				if (!map.get("cityNo").toString().equals(bmap.get("cityNo").toString())) {
					try {
						worker.collet(map.get("cityNo").toString(), bmap.get("cityNo").toString());
					} catch (Exception e) {
						Function.println(e.getMessage());
						e.printStackTrace();
					}
				}
			}
		}
	}

	
	public void collet(String startCity,String endCity) throws Exception {
		String aString = httpHander.getTrain(Config.Date, startCity, endCity);
		Unit.Result result = (Unit.Result) gson.fromJson(aString, Unit.Result.class);
		List<DataBox> list = result.getData();
		for (DataBox dataBox : list) {
			Train train = dataBox.getQueryLeftNewDTO();
			train.setEnd_city_id(1);
			train.setStart_city_id(2);
			dButils.add(train);
		}
		Function.println("--------------"+startCity+"---------"+endCity+"------------");
	}

}
