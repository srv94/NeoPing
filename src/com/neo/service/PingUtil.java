package com.neo.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
public final class PingUtil {
    
	final static Logger logger = Logger.getLogger(PingUtil.class);
    
    public static boolean checkUrl(String urlString) {
        URL url;
        try {
            url = new URL(urlString);
            ImageIO.setUseCache(false);
            ImageIO.read(url);
            return true;
        } catch (MalformedURLException e) {
        	e.printStackTrace();
        	logger.error("This is error 1: " + e.getMessage());
            return false;
        } catch (IOException e) { // NOSONAR
        	e.printStackTrace();
        	logger.error("This is error 2: " + e.getMessage());
            return false;
        }
    }

}
