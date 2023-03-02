package ru.yandex.practicum.catsgram.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class HomeController {
    private static final Logger log = LoggerFactory.getLogger(SimpleController.class);
    @GetMapping("/home2")
    public String homePage2(Model model) {
        log.debug("Получен запрос 2.");
        //return "getFile";
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <title>Home</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Home Page</h1>\n" +
                "<form action=\"/upload\" method=\"post\" enctype=\"multipart/form-data\">\n" +
                "  <input type=\"file\" name=\"file\"><br><br>\n" +
                "  <input type=\"submit\" value=\"Upload File\">\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        // check if file is empty
        if (file.isEmpty()) {
            return "Please select a file to upload";
        }

        try {
            // get the file's original name and create a new file with that name in a directory of your choosing
            String fileName = file.getOriginalFilename();
            String filePath = "c:\\temp\\" + fileName;
            File dest = new File(filePath);
            file.transferTo(dest);
            return "File uploaded successfully";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error uploading file";
        }
    }
}
