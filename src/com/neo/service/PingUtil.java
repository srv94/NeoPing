package com.neo.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public final class PingUtil {
    
    
    public static boolean checkUrl(String urlString) {
        URL url;
        try {
            url = new URL(urlString);
            ImageIO.read(url);
            return true;
        } catch (MalformedURLException e) {
            return false;
        } catch (IOException e) { // NOSONAR
            return false;
        }
    }

}
