package me.aborozdykh.amazonreview.controller;

import me.aborozdykh.amazonreview.service.DataReaderService;
import me.aborozdykh.amazonreview.util.DataToDbSaver;
import me.aborozdykh.amazonreview.util.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Andrii Borozdykh
 */
@Controller
@RequestMapping("/file")
public class DataReaderController {
    private final DataToDbSaver dataToDbSaver;
    private final DataReaderService dataReaderService;

    public DataReaderController(DataToDbSaver dataToDbSaver,
                                DataReaderService dataReaderService) {
        this.dataToDbSaver = dataToDbSaver;
        this.dataReaderService = dataReaderService;
    }

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (dataReaderService.hasCorrectFormat(file)) {
            try {
                var reviewRequestDtoList = dataReaderService
                        .getDataFromFile(file.getInputStream());
                dataToDbSaver.saveToDb(reviewRequestDtoList);

                message = "Uploaded the file successfully: "
                        + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity
                        .status(HttpStatus.EXPECTATION_FAILED)
                        .body(new ResponseMessage(message));
            }
        }

        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }
}
