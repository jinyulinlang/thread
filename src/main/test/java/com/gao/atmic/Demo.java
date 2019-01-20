package com.gao.atmic;

import com.sun.deploy.net.HttpRequest;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

public class Demo {
    private HttpRequest request;

    private AtomicReference<HttpRequest> atomicReference=new AtomicReference<> ();
    @Test
    public void name() {
        Demo demo = new Demo ();
        atomicReference.set (this.request);
        HttpRequest httpRequest = atomicReference.get ();

    }
}
