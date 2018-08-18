
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

    @Override
    public boolean moveFiles() {
        boolean moved = false;
        CamelContext context = new DefaultCamelContext();
        try {
            RouteBuilder routeBuilder = new CustomRouteBuilder();
            context.addRoutes(routeBuilder);
            context.start();
            Thread.sleep(5000);
            context.stop();
            moved = true;
        } catch (Exception e) {
            LOGGER.error("Error -> {}", e);
        }

        return moved;
    }
}
