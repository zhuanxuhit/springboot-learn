package com.edu.springboot.tomcat;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.valves.AccessLogValve;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author zhuanxu
 */
@Component
public class MyEmbeddedServletContainerCustomizer implements EmbeddedServletContainerCustomizer {
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        // class org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory
        TomcatEmbeddedServletContainerFactory factory = (TomcatEmbeddedServletContainerFactory) container;
        factory.setPort(8081);
        factory.setDocumentRoot(new File("/tmp/tomcat"));
        factory.addContextValves(getAccessLogValues());
        factory.addConnectorCustomizers(new MyTomcatConnectorCustomizer());
    }
    private AccessLogValve getAccessLogValues() {
        AccessLogValve log = new AccessLogValve();
        log.setDirectory("/tmp/tomcat/log");
        log.setEnabled(true);
        log.setPattern("%h %l %u %t \"%r\" %s %b");
        log.setPrefix("springboot-access-log");
        log.setSuffix(".txt");
        return log;
    }
}

class MyTomcatConnectorCustomizer implements TomcatConnectorCustomizer{

    @Override
    public void customize(Connector connector) {
        System.out.println(connector.getProtocol());
        System.out.println(connector.getProtocolHandler().getClass());
        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
        // 最大连接数
        protocol.setMaxConnections(2000);
        // 最大线程数
        protocol.setMaxThreads(500);
    }
}
