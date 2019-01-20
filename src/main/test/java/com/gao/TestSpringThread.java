package com.gao;

import com.gao.config.Config;
import com.gao.service.DemoService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpringThread {
    AnnotationConfigApplicationContext context = null;

    @Before
    public void setUp() throws Exception {
        context = new AnnotationConfigApplicationContext (Config.class);
    }

    @Test
    public void testSpringThread() throws InterruptedException {
        DemoService bean = context.getBean (DemoService.class);
        bean.a ();
        System.out.println ("-------------");
        bean.b ();
    }


    @After
    public void tearDown() throws Exception {
        context.close ();
    }
}
