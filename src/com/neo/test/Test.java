package com.neo.test;

import com.neo.service.PingUtil;


public class Test {
    public static void main(String[] args) {
      System.out.println(PingUtil.checkUrl("http://10.1.61.133:6688/finnone-webapp/app/auth/getCaptcha?1465214195631"));
    }

}
