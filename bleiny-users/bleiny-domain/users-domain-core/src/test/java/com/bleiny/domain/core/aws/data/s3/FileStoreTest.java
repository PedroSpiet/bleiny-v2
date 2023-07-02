package com.bleiny.domain.core.aws.data.s3;

import com.amazonaws.auth.AnonymousAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ActiveProfiles(value = "test")
class FileStoreTest {

    @InjectMocks
    private FileStore fileStore;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Saving image in s3 bucket")
    void save() {

    }

    @Test
    void download() {
    }
}