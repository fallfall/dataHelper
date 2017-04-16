package dataHelper;

import com.google.gson.Gson;

import Util.Function;

public class Collector {
	
	static String url="https://kyfw.12306.cn/otn/leftTicket/query?leftTicketDTO.train_date=2017-05-04&leftTicketDTO.from_station=BJP&leftTicketDTO.to_station=SHH&purpose_codes=ADULT";
	static Gson gson =new Gson();
	
	public static void main(String[] args) {
		String jsonstr="{"
               + "\"train_no\":\"240000G1010C\","
               +"\"station_train_code\":\"G101\","
               +"\"start_station_telecode\":\"VNP\","
                +"\"start_station_name\":\"北京南\","
                +"\"end_station_telecode\":\"AOH\","
                +"\"end_station_name\":\"上海虹桥\","
                +"\"from_station_telecode\":\"VNP\","
                +"\"from_station_name\":\"北京南\","
                +"\"to_station_telecode\":\"AOH\","
                +"\"to_station_name\":\"上海虹桥\","
                +"\"start_time\":\"06:44\","
                +"\"arrive_time\":\"12:38\","
                +"\"day_difference\":\"0\","
                +"\"train_class_name\":\"\","
                +"\"lishi\":\"05:54\","
                +"\"canWebBuy\":\"IS_TIME_NOT_BUY\","
                +"\"lishiValue\":\"354\","
                +"\"yp_info\":\"xBOHKTUBtQarCFQhR%2BEOhSluqb%2BYJWx1SyQ5z0viY6QIn89L\","
                +"\"control_train_day\":\"20301231\","
                +"\"start_train_date\":\"20170504\","
                +"\"seat_feature\":\"O3M393\","
                +"\"yp_ex\":\"O0M090\","
                +"\"train_seat_feature\":\"3\","
                +"\"train_type_code\":\"2\","
                +"\"start_province_code\":\"31\","
                +"\"start_city_code\":\"0357\","
                +"\"end_province_code\":\"33\","
                +"\"end_city_code\":\"0712\","
                +"\"seat_types\":\"OM9\","
                +"\"location_code\":\"P2\","
                +"\"from_station_no\":\"01\","
                +"\"to_station_no\":\"11\","
                +"\"control_day\":\"29\","
                +"\"sale_time\":\"1230\","
                +"\"is_support_card\":\"1\","
                +"\"controlled_train_flag\":\"0\","
                +"\"controlled_train_message\":\"正常车次，不受控\","
                +"\"gg_num\":\"--\","
                +"\"gr_num\":\"--\","
                +"\"qt_num\":\"--\","
                +"\"rw_num\":\"--\","
                +"\"rz_num\":\"--\","
                +"\"tz_num\":\"--\","
                +"\"wz_num\":\"--\","
                +"\"yb_num\":\"--\","
                +"\"yw_num\":\"--\","
                +"\"yz_num\":\"--\","
                +"\"ze_num\":\"有\","
                +"\"zy_num\":\"有\","
                +"\"swz_num\":\"有\""
				+ "}";
//		System.out.println("HHHH");
//		Train train =gson.fromJson(jsonstr, Train.class);
//		Function.println(train.getStart_station_name());
//		Function.println(train.getEnd_station_name());
//		Function.println("haha");
	}
}
 