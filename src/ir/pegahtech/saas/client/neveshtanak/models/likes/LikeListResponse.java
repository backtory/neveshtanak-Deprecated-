package ir.pegahtech.saas.client.neveshtanak.models.likes;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Date;

import ir.pegahtech.saas.client.shared.models.*;
import ir.pegahtech.saas.client.neveshtanak.models.likes.*;
import ir.pegahtech.saas.client.neveshtanak.models.jomles.*;


import ir.pegahtech.saas.client.shared.enums.*;


public class LikeListResponse extends BaseModel {





	@SerializedName("totalCount")
	private Integer totalCount;

	@SerializedName("data")
	private List<LikeEntity> data;


	
	
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
		notifyChange("TotalCount", totalCount);
	}
	public List<LikeEntity> getData() {
		return data;
	}
	public void setData(List<LikeEntity> data) {
		this.data = data;
		notifyChange("Data", data);
	}

}
