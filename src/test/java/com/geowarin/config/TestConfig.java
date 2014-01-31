package com.geowarin.config;

import com.geowarin.rest.RestResource;
import com.geowarin.service.MessageService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Date: 31/01/2014
 * Time: 00:41
 *
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
@Configuration
@ComponentScan(basePackageClasses = {RestResource.class, MessageService.class})
public class TestConfig {
}
