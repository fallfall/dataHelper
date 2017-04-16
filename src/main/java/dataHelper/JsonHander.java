package dataHelper;

import java.util.List;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

import com.google.gson.Gson;

import Unit.DataBox;
import Util.Function;

public class JsonHander {
	
	static Gson gson=new Gson();
	static String url="https://kyfw.12306.cn/otn/leftTicket/query?leftTicketDTO.train_date=2017-05-04&leftTicketDTO.from_station=BJP&leftTicketDTO.to_station=SHH&purpose_codes=ADULT";
	   
	public static void main(String[] args) {
		HttpHander test=new HttpHander();
		String aString=null;
//        try {
//			 aString=test.getTrain(url);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Scanner scanner=new Scanner(System.in);
		aString=scanner.nextLine();
		
        System.out.println(aString);
        Unit.Result result=(Unit.Result) gson.fromJson(aString, Unit.Result.class);
        List<DataBox> list=result.getData();
        for (DataBox dataBox : list) {
			Function.println(
					"------"+dataBox.getQueryLeftNewDTO().getLishiValue()
					+"-------"+dataBox.getQueryLeftNewDTO().getStart_station_name()
					+"-------"+dataBox.getQueryLeftNewDTO().getEnd_station_name());
		}
	}
	

}
