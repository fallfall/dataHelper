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
		dButils.clear();
		analysis.initity();
		List<Map<String, Object>> aList=dButils.getCity();
		for (Map<String, Object> map : aList) {
			for (Map<String, Object> bmap : aList) {
				if (!map.get("cityNo").toString().equals(bmap.get("cityNo").toString())) {
					try {
						worker.collet(map,bmap );
					} catch (Exception e) {
						Function.println(e.getMessage());
						e.printStackTrace();
					}
				}
			}
		}
	}

	
	public void collet(Map< String, Object> startCity,Map< String, Object> endCity) throws Exception {
		String aString = httpHander.getTrain(Config.Date, startCity.get("cityNo").toString(), endCity.get("cityNo").toString());
		Unit.Result result = (Unit.Result) gson.fromJson(aString, Unit.Result.class);
		List<DataBox> list = result.getData();
		for (DataBox dataBox : list) {
			Train train = dataBox.getQueryLeftNewDTO();
			train.setEnd_city_id(Integer.valueOf(endCity.get("id").toString()));
			train.setStart_city_id(Integer.valueOf(startCity.get("id").toString()));
			dButils.add(train);
		}
		Function.println("--------------"+startCity+"---------"+endCity+"------------");
	}

}
