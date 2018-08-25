
package com.leysoft.service.imple;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leysoft.route.CustomRouteBuilder;
import com.leysoft.service.inter.FileService;

public class FileServiceImp implements FileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileServiceImp.class);

    private static final CamelContext CONTEXT = new DefaultCamelContext();

    @Override
    public boolean moveFiles() {
        boolean moved = false;
        try {
            RouteBuilder routeBuilder = new CustomRouteBuilder();
            CONTEXT.addRoutes(routeBuilder);
            CONTEXT.start();
            Thread.sleep(5000);
            CONTEXT.stop();
            moved = true;
        } catch (Exception e) {
            LOGGER.error("Error -> {}", e);
        }
        return moved;
    }
}
