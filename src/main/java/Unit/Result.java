package Unit;

import java.awt.List;

public class Result {


	boolean status;
	int httpstatus;
	java.util.List<DataBox> data;

	public Result() {
	}

	public java.util.List<DataBox> getData() {
		return data;
	}

	public void setData(java.util.List<DataBox> data) {
		this.data = data;
	}



	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getHttpstatus() {
		return httpstatus;
	}

	public void setHttpstatus(int httpstatus) {
		this.httpstatus = httpstatus;
	}

}
