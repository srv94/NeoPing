package com.neo.service;

import com.neo.dto.NeoDirectory;

public interface NeoDirectoryService {

	public int saveNeoDirectory(NeoDirectory neoDirectory);
	public int updateNeoDirectory(NeoDirectory neoDirectory);
}
