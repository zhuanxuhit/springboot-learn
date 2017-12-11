package com.edu.springboot.web;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 *
 * @author zhuanxu
 */
@Component
public class DocumentDirectoryCustomizer implements EmbeddedServletContainerCustomizer{
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
//        System.out.println(container.);
//        container.setDocumentRoot(new File(""));
    }
}
