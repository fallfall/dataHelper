package dataHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import DbBase.DButils;
import jdk.nashorn.internal.runtime.regexp.joni.Config;

/*
 *    @author linqiuping
 */
public class Analysis {

	private DButils dButils=new DButils();
	
	public void initity() {
		getCityInfo(readTxtFile(Util.Config.CITY_PATH));
	}
	
	public void getCityInfo(String html) {
		Document document;
		document = Jsoup.parse(html);
		Element div = document.getElementById("form_cities2").getElementById("ul_list1");
		Elements elements = div.getElementsByTag("li");
		int id=0;
		for (Element element : elements) {
			dButils.add(element.attr("title") ,  element.attr("data"),id);
			id++;
		}
	}

	public String readTxtFile(String filePath) {
		String totalTxt = "";
		try {
			String encoding = "UTF8";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = "";

				while ((lineTxt = bufferedReader.readLine()) != null) {
					totalTxt += lineTxt;
				}
				read.close();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return totalTxt;
	}

}
