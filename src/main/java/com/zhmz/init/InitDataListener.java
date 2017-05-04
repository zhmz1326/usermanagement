package com.zhmz.init;

import com.zhmz.user.entity.UserInfo;
import com.zhmz.user.service.UserService;
import jdk.nashorn.api.scripting.URLReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.io.BufferedReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class InitDataListener implements InitializingBean, ServletContextAware {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Value("${init.data.location}")
    private String location;

    private ServletContext servletContext;

    @Autowired
    private UserService userService;

    @Override
    public void afterPropertiesSet() throws Exception {
        URL url = servletContext.getResource(location);

        URLReader ur = new URLReader(url);
        BufferedReader br = new BufferedReader(ur);
        String line = null;
        int count = 0;

        List<UserInfo> data = new ArrayList<>();
        while(!StringUtils.isEmpty(line = br.readLine())) {
            count++;
            if (count == 1) { // 跳过第一行
                continue;
            }

            String[] arr = line.split("\\|");

            if (arr.length != 4) {
                logger.warn("Incorrect line: " + line);
                continue;
            }

            UserInfo info = new UserInfo();
            info.setId(Long.parseLong(arr[0].trim()));
            info.setLoginname(arr[1].trim());
            info.setName(arr[3].trim());
            data.add(info);
        }

        userService.setInitData(data);
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
