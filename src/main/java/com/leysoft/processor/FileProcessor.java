
package com.leysoft.processor;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class FileProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String fileName = exchange.getIn().getHeader(Exchange.FILE_NAME, String.class);
        String newFileName =
                new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()) + fileName;
        exchange.getIn().setHeader(Exchange.FILE_NAME, newFileName);
    }
}
