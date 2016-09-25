package com.neo.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="NEO_DIRECTORY")
public class NeoDirectory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int indent = 0;
	private String name;
	private String path;
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "directory_ref_fk")
	private List<NeoDirectory> directories;
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "directory_file_fk")
	private List<NeoFile> files;

	public NeoDirectory() {
		super();
		this.setIndent(0);
		setDirectories(new ArrayList<NeoDirectory>());
		setFiles(new ArrayList<NeoFile>());
	}
	
	public NeoDirectory(String name) {
		super();
		this.setName(name);
		this.setIndent(0);
		setDirectories(new ArrayList<NeoDirectory>());
		setFiles(new ArrayList<NeoFile>());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public List<NeoDirectory> getDirectories() {
		return directories;
	}

	public void setDirectories(List<NeoDirectory> directories) {
		this.directories = directories;
	}

	public List<NeoFile> getFiles() {
		return files;
	}

	public void setFiles(List<NeoFile> files) {
		this.files = files;
	}
	
	public void addNewDirectory(NeoDirectory directory){
		this.directories.add(directory);
	}
	
	public void addNewFile(NeoFile file){
		this.files.add(file);
	}

	public int getIndent() {
		return indent;
	}

	public void setIndent(int indent) {
		this.indent = indent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
