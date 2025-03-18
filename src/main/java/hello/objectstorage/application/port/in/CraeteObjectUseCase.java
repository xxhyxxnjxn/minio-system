package hello.objectstorage.application.port.in;

import hello.objectstorage.representation.request.ObjectOperationInfo;

public interface CraeteObjectUseCase {
    void createObject(ObjectOperationInfo objectOperationInfo);
}
