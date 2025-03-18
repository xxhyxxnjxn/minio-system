package hello.objectstorage.infrastructure.out.minio;

import hello.objectstorage.application.port.out.ObjectStorageAPIs;
import hello.objectstorage.representation.request.ObjectOperationInfo;
import io.minio.GetObjectArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
@RequiredArgsConstructor
public class MinioAPI implements ObjectStorageAPIs {
    private final MinioClient minioClient;

    public void createBucket(String bucketName)  {
        try {
            System.out.println("bucketName: " + bucketName);
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        } catch (ErrorResponseException e) {
            throw new RuntimeException(e);
        } catch (InsufficientDataException e) {
            throw new RuntimeException(e);
        } catch (InternalException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (InvalidResponseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (ServerException e) {
            throw new RuntimeException(e);
        } catch (XmlParserException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void uploadObject(ObjectOperationInfo objectOperationInfo) {
        try {
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(objectOperationInfo.getBucketName())
                            .object(objectOperationInfo.getKey()) // Key 기반 저장
                            .stream(new FileInputStream(objectOperationInfo.getFileName()), new File(objectOperationInfo.getFileName()).length(), -1)
                            .build()
            );
        } catch (ErrorResponseException e) {
            throw new RuntimeException(e);
        } catch (InsufficientDataException e) {
            throw new RuntimeException(e);
        } catch (InternalException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (InvalidResponseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (ServerException e) {
            throw new RuntimeException(e);
        } catch (XmlParserException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getObject(ObjectOperationInfo objectOperationInfo0) {
        InputStream stream = null;
        try {
            String key = objectOperationInfo0.getKey();
            stream = minioClient.getObject(
                    GetObjectArgs.builder()
                            .bucket(objectOperationInfo0.getBucketName())
                            .object(key)
                            .build()
            );
            Files.copy(stream, Paths.get(key.split("/")[1]), StandardCopyOption.REPLACE_EXISTING);
        } catch (ErrorResponseException e) {
            throw new RuntimeException(e);
        } catch (InsufficientDataException e) {
            throw new RuntimeException(e);
        } catch (InternalException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (InvalidResponseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (ServerException e) {
            throw new RuntimeException(e);
        } catch (XmlParserException e) {
            throw new RuntimeException(e);
        }

    }
}
