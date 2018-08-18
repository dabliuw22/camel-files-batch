
package com.leysoft.route;

import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import com.leysoft.processor.FileProcessor;

public class CustomRouteBuilder extends RouteBuilder {

    private static final String FROM = "data/input";

    private static final String TO = "data/output";

    @Override
    public void configure() throws Exception {
        Processor processor = new FileProcessor();
        from("file://" + FROM + "?noop=true").process(processor).to("file://" + TO);
    }
}
