package org.example;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Test implements InitializingBean, DisposableBean {
    public void destroy() throws Exception {
        
    }

    public void afterPropertiesSet() throws Exception {

    }
}
