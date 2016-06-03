package com.neo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ENVIRONMENT")
public class EnvironmentDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column private String keyId;
	@Column private String envName;
	@Column private String envUrl;
	@Column private String envLogUrl;
	@Column private String envLogUser;
	@Column private String envLogPass;
	@Column private String envLog;
	@Column private String envWar;
	@Column private String envServerLog;
	@Column private String dbUrl;
	@Column private String dbUser;
	@Column private String dbPass;
	
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
	public String getKeyId() {
		return keyId;
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
	@Override
	public String toString() {
		return "EnvironmentDTO [keyId=" + keyId + ", envName=" + envName
				+ ", envUrl=" + envUrl + ", envLogUrl=" + envLogUrl
				+ ", envLogUser=" + envLogUser + ", envLogPass=" + envLogPass
				+ ", envLog=" + envLog + ", envWar=" + envWar
				+ ", envServerLog=" + envServerLog + ", dbUrl=" + dbUrl
				+ ", dbUser=" + dbUser + ", dbPass=" + dbPass + "]";
	}
	
	// TODO improve this.....

}
