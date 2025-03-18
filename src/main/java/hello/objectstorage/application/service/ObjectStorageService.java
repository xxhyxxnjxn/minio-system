package hello.objectstorage.application.service;

import hello.objectstorage.application.port.in.CraeteObjectUseCase;
import hello.objectstorage.application.port.in.CreateBucketUseCase;
import hello.objectstorage.application.port.in.GetObjectUseCase;
import hello.objectstorage.application.port.out.ObjectStorageAPIs;
import hello.objectstorage.representation.request.ObjectOperationInfo;
import io.minio.errors.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
@RequiredArgsConstructor
public class ObjectStorageService implements CreateBucketUseCase, CraeteObjectUseCase, GetObjectUseCase {
    private final ObjectStorageAPIs minioApi;


    @Override
    public void createBucket(String bucketName)  {
        minioApi.createBucket(bucketName);
    }

    @Override
    public void createObject(ObjectOperationInfo objectOperationInfo) {
        minioApi.uploadObject(objectOperationInfo);
    }

    @Override
    public void getObject(ObjectOperationInfo objectOperationInfo) {
        minioApi.getObject(objectOperationInfo);
    }
}
