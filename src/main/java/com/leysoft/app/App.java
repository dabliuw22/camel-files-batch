
package com.leysoft.app;

import com.leysoft.service.imple.FileServiceImp;
import com.leysoft.service.inter.FileService;

public class App {

    public static void main(String[] args) {
        FileService fileService = new FileServiceImp();
        fileService.moveFiles();
    }

}
