package com.neo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonProperty;


@Entity
@Table(name="ENVIRONMENT")
public class EnvironmentDTO {
	
	@Id
	@JsonProperty("key")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column private String keyId;
	@JsonProperty("environmentType") @Column private String environmentType;
	@JsonProperty("envName") @Column private String envName;
	@JsonProperty("envUrl") @Column private String envUrl;
	@JsonProperty("revisionNumber") @Column private String revisionNumber;
	@JsonProperty("envLogUrl") @Column private String envLogUrl;
	@JsonProperty("envLogUser") @Column private String envLogUser;
	@JsonProperty("envLogPass") @Column private String envLogPass;
	@JsonProperty("envLog") @Column private String envLog;
	@JsonProperty("envWar") @Column private String envWar;
	@JsonProperty("envServerLog") @Column private String envServerLog;
	@JsonProperty("dbUrl") @Column private String dbUrl;
	@JsonProperty("dbUser") @Column private String dbUser;
	@JsonProperty("dbPass") @Column private String dbPass;
	@JsonProperty("dbSchema") @Column private String dbSchema;
	@JsonProperty("syncUrl") @Column private String syncUrl;

    public String getSyncUrl() {
		return syncUrl;
	}
	public void setSyncUrl(String syncUrl) {
		this.syncUrl = syncUrl;
	}
	public EnvironmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EnvironmentDTO(String keyId, String envName, String envUrl,
			String envLogUrl, String envLogUser, String envLogPass,
			String envLog, String envWar, String envServerLog, String dbUrl,
			String dbUser, String dbPass) {
		super();
		this.keyId = keyId;
		this.envName = envName;
		this.envUrl = envUrl;
		this.envLogUrl = envLogUrl;
		this.envLogUser = envLogUser;
		this.envLogPass = envLogPass;
		this.envLog = envLog;
		this.envWar = envWar;
		this.envServerLog = envServerLog;
		this.dbUrl = dbUrl;
		this.dbUser = dbUser;
		this.dbPass = dbPass;
	}
	public int getId() {
		return id;
	}
	public String getKeyId() {
		return keyId;
	}
	public void setId(int id){
	    this.id=id;
	}
	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}
	public String getEnvName() {
		return envName;
	}
	public void setEnvName(String envName) {
		this.envName = envName;
	}
	public String getEnvUrl() {
		return envUrl;
	}
	public void setEnvUrl(String envUrl) {
		this.envUrl = envUrl;
	}
	public String getEnvLogUrl() {
		return envLogUrl;
	}
	public void setEnvLogUrl(String envLogUrl) {
		this.envLogUrl = envLogUrl;
	}
	public String getEnvLogUser() {
		return envLogUser;
	}
	public void setEnvLogUser(String envLogUser) {
		this.envLogUser = envLogUser;
	}
	public String getEnvLogPass() {
		return envLogPass;
	}
	public void setEnvLogPass(String envLogPass) {
		this.envLogPass = envLogPass;
	}
	public String getEnvLog() {
		return envLog;
	}
	public void setEnvLog(String envLog) {
		this.envLog = envLog;
	}
	public String getEnvWar() {
		return envWar;
	}
	public void setEnvWar(String envWar) {
		this.envWar = envWar;
	}
	public String getEnvServerLog() {
		return envServerLog;
	}
	public void setEnvServerLog(String envServerLog) {
		this.envServerLog = envServerLog;
	}
	public String getDbUrl() {
		return dbUrl;
	}
	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}
	public String getDbUser() {
		return dbUser;
	}
	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}
	public String getDbPass() {
		return dbPass;
	}
	public void setDbPass(String dbPass) {
		this.dbPass = dbPass;
	}
	public String getRevisionNumber() {
		return revisionNumber;
	}
	public void setRevisionNumber(String revisionNumber) {
		this.revisionNumber = revisionNumber;
	}
	public String getDbSchema() {
        return dbSchema;
    }
    public void setDbSchema(String dbSchema) {
        this.dbSchema = dbSchema;
    }
    public String getEnvironmentType() {
		return environmentType;
	}
	public void setEnvironmentType(String environmentType) {
		this.environmentType = environmentType;
	}
	@Override
	public String toString() {
		return "EnvironmentDTO [id=" + id + ", keyId=" + keyId
				+ ", environmentType=" + environmentType + ", envName="
				+ envName + ", envUrl=" + envUrl + ", revisionNumber="
				+ revisionNumber + ", envLogUrl=" + envLogUrl + ", envLogUser="
				+ envLogUser + ", envLogPass=" + envLogPass + ", envLog="
				+ envLog + ", envWar=" + envWar + ", envServerLog="
				+ envServerLog + ", dbUrl=" + dbUrl + ", dbUser=" + dbUser
				+ ", dbPass=" + dbPass + ", dbSchema=" + dbSchema
				+ ", syncUrl=" + syncUrl + "]";
	}

	

}
