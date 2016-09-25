package com.neo.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="NEO_FILE")
public class NeoFile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int indent = 0;
	private String name;
	private String type;
	private String location;
	@ElementCollection
	@CollectionTable(name="PATCH_PATH")
	@JoinColumn(name="file_id")
	private List<String> patchPath;
	
	public NeoFile() {
		super();
		this.setPatchPath(new ArrayList<String>());
	}
	
	public NeoFile(String name,String type,String location) {
		this.setName(name);
		this.setType(type);
		this.setLocation(location);
		this.setPatchPath(new ArrayList<String>());
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<String> getPatchPath() {
		return patchPath;
	}

	public void setPatchPath(List<String> patchPath) {
		this.patchPath = patchPath;
	}
	
	public void addNewPatchPath(String path) {
		this.patchPath.add(path);
	}

	public int getIndent() {
		return indent;
	}

	public void setIndent(int indent) {
		this.indent = indent;
	}

	
}
