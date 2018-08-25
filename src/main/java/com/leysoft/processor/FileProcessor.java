
package com.leysoft.processor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFile;

public class FileProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String fileName = exchange.getIn().getHeader(Exchange.FILE_NAME, String.class);
        String newFileName =
                new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()) + fileName;
        @SuppressWarnings("unchecked")
        GenericFile<File> file = (GenericFile<File>) exchange.getIn().getBody();
        if (file != null) {
            FileReader fileReader = new FileReader(file.getFile());
            try (BufferedReader reader = new BufferedReader(fileReader)) {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String newLine = line + " new";
                    exchange.getIn().setBody(newLine);
                }
            }
        }
        exchange.getIn().setHeader(Exchange.FILE_NAME, newFileName);
    }
}
