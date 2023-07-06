package com.bleiny.domain.core.aws.data.s3;

import com.amazonaws.auth.AnonymousAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;


@ExtendWith(SpringExtension.class)
@ActiveProfiles(value = "test")
class FileStoreTest {

    @MockBean
    private FileStore fileStore;

    @MockBean
    AmazonS3 s3;

    private final static String BUCKET_NAME = "logo-image-users-teste";

    @Test
    @DisplayName("Saving image in s3 bucket")
    void save() throws IOException {

        String path = String.format("%s/%s", BUCKET_NAME, "ASDAWSD-AWDSDAW-SDAWSD");
        String filename = String.format("%s-%s", "teste-oi-pedro", UUID.randomUUID());
        MockMultipartFile file
                = new MockMultipartFile(
                "file",
                "hello.png",
                MediaType.IMAGE_JPEG_VALUE,
                "Hello, World!".getBytes()
        );
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));
        fileStore.save(path, filename, Optional.of(metadata), file.getInputStream());
        Mockito.verify(fileStore, Mockito.times(1)).save(Mockito.anyString(), Mockito.anyString(), Mockito.any(Optional.class),
                Mockito.any(InputStream.class));
    }
}

