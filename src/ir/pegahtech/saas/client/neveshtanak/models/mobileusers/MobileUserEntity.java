package ir.pegahtech.saas.client.Neveshtanak.models.mobileusers;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Date;

import ir.pegahtech.saas.client.shared.models.*;
import ir.pegahtech.saas.client.Neveshtanak.models.mobileusers.*;
import ir.pegahtech.saas.client.Neveshtanak.models.likes.*;
import ir.pegahtech.saas.client.Neveshtanak.models.jomles.*;


import ir.pegahtech.saas.client.shared.enums.*;


public class MobileUserEntity extends BaseModel {

	public static final String COLUMN_Guid = "Guid";
	public static final String COLUMN_CreationDate = "CreationDate";
	public static final String COLUMN_IsDeleted = "IsDeleted";
	public static final String COLUMN_LastModifiedDate = "LastModifiedDate";
	public static final String COLUMN_Owner_ID = "Owner_ID";
	public static final String COLUMN_AccountNonExpired = "Plugin_AccountNonExpired";
	public static final String COLUMN_AccountNonLocked = "Plugin_AccountNonLocked";
	public static final String COLUMN_CredentialsNonExpired = "Plugin_CredentialsNonExpired";
	public static final String COLUMN_EmailAddress = "Plugin_EmailAddress";
	public static final String COLUMN_Enabled = "Plugin_Enabled";
	public static final String COLUMN_Firstname = "Plugin_Firstname";
	public static final String COLUMN_IMEI1 = "Plugin_IMEI1";
	public static final String COLUMN_IsAnonymous = "Plugin_IsAnonymous";
	public static final String COLUMN_Lastname = "Plugin_Lastname";
	public static final String COLUMN_MobilePhoneNumber1 = "Plugin_MobilePhoneNumber1";
	public static final String COLUMN_Password = "Plugin_Password";
	public static final String COLUMN_Username = "Plugin_Username";




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

	@SerializedName("Plugin_AccountNonExpired")
	private Boolean AccountNonExpired;

	@SerializedName("Plugin_AccountNonLocked")
	private Boolean AccountNonLocked;

	@SerializedName("Plugin_CredentialsNonExpired")
	private Boolean CredentialsNonExpired;

	@SerializedName("Plugin_EmailAddress")
	private String EmailAddress;

	@SerializedName("Plugin_Enabled")
	private Boolean Enabled;

	@SerializedName("Plugin_Firstname")
	private String Firstname;

	@SerializedName("Plugin_IMEI1")
	private String IMEI1;

	@SerializedName("Plugin_IsAnonymous")
	private Boolean IsAnonymous;

	@SerializedName("Plugin_Lastname")
	private String Lastname;

	@SerializedName("Plugin_MobilePhoneNumber1")
	private String MobilePhoneNumber1;

	@SerializedName("Plugin_Password")
	private String Password;

	@SerializedName("Plugin_Username")
	private String Username;


	
	
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
	public Boolean getAccountNonExpired() {
		return AccountNonExpired;
	}
	public void setAccountNonExpired(Boolean AccountNonExpired) {
		this.AccountNonExpired = AccountNonExpired;
		notifyChange("Plugin_AccountNonExpired", AccountNonExpired);
	}
	public Boolean getAccountNonLocked() {
		return AccountNonLocked;
	}
	public void setAccountNonLocked(Boolean AccountNonLocked) {
		this.AccountNonLocked = AccountNonLocked;
		notifyChange("Plugin_AccountNonLocked", AccountNonLocked);
	}
	public Boolean getCredentialsNonExpired() {
		return CredentialsNonExpired;
	}
	public void setCredentialsNonExpired(Boolean CredentialsNonExpired) {
		this.CredentialsNonExpired = CredentialsNonExpired;
		notifyChange("Plugin_CredentialsNonExpired", CredentialsNonExpired);
	}
	public String getEmailAddress() {
		return EmailAddress;
	}
	public void setEmailAddress(String EmailAddress) {
		this.EmailAddress = EmailAddress;
		notifyChange("Plugin_EmailAddress", EmailAddress);
	}
	public Boolean getEnabled() {
		return Enabled;
	}
	public void setEnabled(Boolean Enabled) {
		this.Enabled = Enabled;
		notifyChange("Plugin_Enabled", Enabled);
	}
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String Firstname) {
		this.Firstname = Firstname;
		notifyChange("Plugin_Firstname", Firstname);
	}
	public String getIMEI1() {
		return IMEI1;
	}
	public void setIMEI1(String IMEI1) {
		this.IMEI1 = IMEI1;
		notifyChange("Plugin_IMEI1", IMEI1);
	}
	public Boolean getIsAnonymous() {
		return IsAnonymous;
	}
	public void setIsAnonymous(Boolean IsAnonymous) {
		this.IsAnonymous = IsAnonymous;
		notifyChange("Plugin_IsAnonymous", IsAnonymous);
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String Lastname) {
		this.Lastname = Lastname;
		notifyChange("Plugin_Lastname", Lastname);
	}
	public String getMobilePhoneNumber1() {
		return MobilePhoneNumber1;
	}
	public void setMobilePhoneNumber1(String MobilePhoneNumber1) {
		this.MobilePhoneNumber1 = MobilePhoneNumber1;
		notifyChange("Plugin_MobilePhoneNumber1", MobilePhoneNumber1);
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
		notifyChange("Plugin_Password", Password);
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String Username) {
		this.Username = Username;
		notifyChange("Plugin_Username", Username);
	}

}
