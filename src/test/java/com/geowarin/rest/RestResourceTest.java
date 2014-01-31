package com.geowarin.rest;

import com.geowarin.config.JerseyConfig;
import com.geowarin.config.TestConfig;
import org.glassfish.jersey.server.spring.SpringComponentProvider;
import org.glassfish.jersey.test.JerseyTest;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.ws.rs.core.Application;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Date: 31/01/2014
 * Time: 00:20
 *
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
public class RestResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
        return new JerseyConfig()
                .property(SpringComponentProvider.PARAM_SPRING_CONTEXT, context);
    }

    @Test
    public void testHello() {
        final String hello = target("hello").request().get(String.class);
        assertThat(hello).isEqualTo("Hello World");
    }

    @Test
    public void testMessages() throws JSONException {
        final String messages = target("messages").request().get(String.class);
        String expected = "[ " +
                "{ 'owner': 'Joe', 'content': 'Hello'}," +
                "{ 'owner': 'Jane', 'content': 'Spring boot is cool !'}" +
                "]";
        JSONAssert.assertEquals(expected, messages, JSONCompareMode.LENIENT);
    }
}
