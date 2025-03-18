package hello.objectstorage.application.port.in;

import hello.objectstorage.representation.request.ObjectOperationInfo;

public interface GetObjectUseCase {
    void getObject(ObjectOperationInfo objectOperationInfo);
}
