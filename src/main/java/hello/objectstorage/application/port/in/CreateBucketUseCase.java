package hello.objectstorage.application.port.in;

import io.minio.errors.*;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface CreateBucketUseCase {
    void createBucket(String bucketName) ;
}
