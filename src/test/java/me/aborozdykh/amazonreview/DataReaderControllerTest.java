package me.aborozdykh.amazonreview;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.FileInputStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author Andrii Borozdykh
 */

@SpringBootTest
@AutoConfigureMockMvc
public class DataReaderControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testUpload() throws Exception {
        String endpoint = "/file/upload";
        var fis = new FileInputStream("./src/test/resources/test.csv");
        var multipartFile
                = new MockMultipartFile("file", "test.csv", "text/csv", fis);

        MockHttpServletRequestBuilder builder
                = MockMvcRequestBuilders
                .multipart(endpoint)
                .file(multipartFile);

        mockMvc.perform(builder)
                .andExpect(status().is(200))
                .andExpect(content()
                        .string("{\"message\":\"Uploaded the file successfully: test.csv\"}"));
    }
}
