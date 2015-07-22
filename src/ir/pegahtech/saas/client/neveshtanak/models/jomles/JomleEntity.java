package ir.pegahtech.saas.client.neveshtanak.models.jomles;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Date;

import ir.pegahtech.saas.client.shared.models.*;
import ir.pegahtech.saas.client.neveshtanak.models.likes.*;
import ir.pegahtech.saas.client.neveshtanak.models.jomles.*;


import ir.pegahtech.saas.client.shared.enums.*;


public class JomleEntity extends BaseModel {

	public static final String COLUMN_Guid = "Guid";
	public static final String COLUMN_CreationDate = "CreationDate";
	public static final String COLUMN_IsDeleted = "IsDeleted";
	public static final String COLUMN_LastModifiedDate = "LastModifiedDate";
	public static final String COLUMN_Owner_ID = "Owner_ID";
	public static final String COLUMN_jomle = "jomle";
	public static final String COLUMN_likesCount = "likesCount";
	public static final String COLUMN_userId = "userId";
	public static final String COLUMN_userName = "userName";


	public static final String INCLUDE_jomleList = "jomleList";


	@SerializedName("Guid")
	private String Guid;

	@SerializedName("CreationDate")
	private Date CreationDate;

	@SerializedName("IsDeleted")
	private Boolean IsDeleted;

	@SerializedName("LastModifiedDate")
	private Date LastModifiedDate;

	@SerializedName("Owner_ID")
	private String Owner_ID;

	@SerializedName("jomle")
	private String jomle;

	@SerializedName("likesCount")
	private Integer likesCount;

	@SerializedName("userId")
	private String userId;

	@SerializedName("userName")
	private String userName;

	@SerializedName("jomleList")
	private List<LikeEntity> jomleList;


	
	
	public String getGuid() {
		return Guid;
	}
	public void setGuid(String Guid) {
		this.Guid = Guid;
		notifyChange("Guid", Guid);
	}
	public Date getCreationDate() {
		return CreationDate;
	}
	public void setCreationDate(Date CreationDate) {
		this.CreationDate = CreationDate;
		notifyChange("CreationDate", CreationDate);
	}
	public Boolean getIsDeleted() {
		return IsDeleted;
	}
	public void setIsDeleted(Boolean IsDeleted) {
		this.IsDeleted = IsDeleted;
		notifyChange("IsDeleted", IsDeleted);
	}
	public Date getLastModifiedDate() {
		return LastModifiedDate;
	}
	public void setLastModifiedDate(Date LastModifiedDate) {
		this.LastModifiedDate = LastModifiedDate;
		notifyChange("LastModifiedDate", LastModifiedDate);
	}
	public String getOwner_ID() {
		return Owner_ID;
	}
	public void setOwner_ID(String Owner_ID) {
		this.Owner_ID = Owner_ID;
		notifyChange("Owner_ID", Owner_ID);
	}
	public String getJomle() {
		return jomle;
	}
	public void setJomle(String jomle) {
		this.jomle = jomle;
		notifyChange("Jomle", jomle);
	}
	public Integer getLikesCount() {
		return likesCount;
	}
	public void setLikesCount(Integer likesCount) {
		this.likesCount = likesCount;
		notifyChange("LikesCount", likesCount);
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
		notifyChange("UserId", userId);
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
		notifyChange("UserName", userName);
	}
	public List<LikeEntity> getJomleList() {
		return jomleList;
	}
	public void setJomleList(List<LikeEntity> jomleList) {
		this.jomleList = jomleList;
		notifyChange("JomleList", jomleList);
	}

}
