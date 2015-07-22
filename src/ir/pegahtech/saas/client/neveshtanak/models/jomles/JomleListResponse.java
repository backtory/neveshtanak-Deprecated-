package ir.pegahtech.saas.client.neveshtanak.models.jomles;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Date;

import ir.pegahtech.saas.client.shared.models.*;
import ir.pegahtech.saas.client.neveshtanak.models.likes.*;
import ir.pegahtech.saas.client.neveshtanak.models.jomles.*;


import ir.pegahtech.saas.client.shared.enums.*;


public class JomleListResponse extends BaseModel {





	@SerializedName("totalCount")
	private Integer totalCount;

	@SerializedName("data")
	private List<JomleEntity> data;


	
	
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
		notifyChange("TotalCount", totalCount);
	}
	public List<JomleEntity> getData() {
		return data;
	}
	public void setData(List<JomleEntity> data) {
		this.data = data;
		notifyChange("Data", data);
	}

}
