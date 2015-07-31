package ir.pegahtech.saas.client.Neveshtanak.models.jomlelikes;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Date;

import ir.pegahtech.saas.client.shared.models.*;
import ir.pegahtech.saas.client.Neveshtanak.models.mobileusers.*;
import ir.pegahtech.saas.client.Neveshtanak.models.jomlelikes.*;
import ir.pegahtech.saas.client.Neveshtanak.models.jomles.*;


import ir.pegahtech.saas.client.shared.enums.*;


public class JomleLikeEntity extends BaseModel {



	public static final String COLUMN_Guid = "Guid";
	public static final String COLUMN_CreationDate = "CreationDate";
	public static final String COLUMN_IsDeleted = "IsDeleted";
	public static final String COLUMN_LastModifiedDate = "LastModifiedDate";
	public static final String COLUMN_Owner_ID = "Owner_ID";
	public static final String COLUMN_Jomle = "Jomle";
	public static final String COLUMN_UserId = "UserId";


	public static final String INCLUDE_RelatedJomle = "RelatedJomle";


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

	@SerializedName("Jomle")
	private String Jomle;

	@SerializedName("UserId")
	private String UserId;

	@SerializedName("RelatedJomle")
	private JomleEntity RelatedJomle;


	
	
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
		return Jomle;
	}
	public void setJomle(String Jomle) {
		this.Jomle = Jomle;
		notifyChange("Jomle", Jomle);
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String UserId) {
		this.UserId = UserId;
		notifyChange("UserId", UserId);
	}
	public JomleEntity getRelatedJomle() {
		return RelatedJomle;
	}
	public void setRelatedJomle(JomleEntity RelatedJomle) {
		this.RelatedJomle = RelatedJomle;
		notifyChange("RelatedJomle", RelatedJomle);
	}

}
