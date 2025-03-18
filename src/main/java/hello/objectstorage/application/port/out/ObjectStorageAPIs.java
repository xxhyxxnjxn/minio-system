package hello.objectstorage.application.port.out;

import hello.objectstorage.representation.request.ObjectOperationInfo;
import io.minio.errors.*;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface ObjectStorageAPIs {
    void createBucket(String bucketName) ;
    void uploadObject(ObjectOperationInfo objectOperationInfo);
    void getObject(ObjectOperationInfo objectOperationInfo);
}
