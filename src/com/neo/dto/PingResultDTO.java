package com.neo.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PING_RESULT")
public class PingResultDTO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column String Keyid;
    @Column boolean result;
    @Column Timestamp timestamp;
    public PingResultDTO() {
        super();
        // TODO Auto-generated constructor stub
    }
    public PingResultDTO(String KeyId,Timestamp timestamp) {
        super();
        this.Keyid = KeyId;
        this.timestamp = timestamp;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getKeyid() {
        return Keyid;
    }
    public void setKeyid(String keyid) {
        Keyid = keyid;
    }
    public boolean isResult() {
        return result;
    }
    public void setResult(boolean result) {
        this.result = result;
    }
    public Timestamp getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
    @Override
    public String toString() {
        return "PingResultDTO [id=" + id + ", Keyid=" + Keyid + ", result=" + result + ", timestamp=" + timestamp + "]";
    }

}
