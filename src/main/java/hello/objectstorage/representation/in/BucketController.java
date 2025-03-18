package hello.objectstorage.representation.in;

import hello.objectstorage.application.port.in.CraeteObjectUseCase;
import hello.objectstorage.application.port.in.CreateBucketUseCase;
import hello.objectstorage.application.port.in.GetObjectUseCase;
import hello.objectstorage.representation.request.ObjectOperationInfo;
import hello.objectstorage.representation.request.ObjectOperationInfos;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buckets")
@RequiredArgsConstructor
public class BucketController {
    private final CreateBucketUseCase createBucketUseCase;
    private final CraeteObjectUseCase createCraeteObjectUseCase;
    private final GetObjectUseCase getObjectUseCase;

    @PostMapping("/{name}")
    public ResponseEntity<String> createBucket(@PathVariable String name) {
        try {
            createBucketUseCase.createBucket(name);
            return ResponseEntity.ok("Bucket created successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Create Bucket failed");
        }
    }

    @GetMapping
    public ResponseEntity<String> getBuckets() {
        return ResponseEntity.ok("Buckets info : ");
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> getBucket(@PathVariable String name) {
        return ResponseEntity.ok("Bucket info : "+name);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteBucket(@PathVariable String name) {
        return ResponseEntity.ok("Deleted Bucket info : "+name);
    }

    //오브젝트 단일 업로드
    @PostMapping("/{name}/objects/{objectName}")
    public ResponseEntity<String> createObject(@PathVariable("name") String name, @PathVariable("objectName") String objectName, @RequestBody ObjectOperationInfo objectOperationInfo) {
        try {
            createCraeteObjectUseCase.createObject(objectOperationInfo);
            return ResponseEntity.ok("Object created successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Create Object failed");
        }
    }

    //오브젝트 멀티 업로드
    @PostMapping("/{name}/objects")
    public ResponseEntity<String> createObjects(@PathVariable("name") String name, @RequestBody ObjectOperationInfos objectOperationInfos) {
        return ResponseEntity.ok("Object created successfully");
    }

    //오브젝트 목록 조회
    @GetMapping("/{name}/objects")
    public ResponseEntity<String> getObjects(@PathVariable("name") String name,ObjectOperationInfo objectOperationInfo) {
        return ResponseEntity.ok("Objects info");
    }

    //특정 오브젝트 조회
    @GetMapping("/{name}/objects/{objectName}")
    public ResponseEntity<String> getObject(@PathVariable("name") String name, @PathVariable("objectName") String objectName,ObjectOperationInfo objectOperationInfo) {
        return ResponseEntity.ok("Object info :"+objectName);
    }

    //오브젝트 수정
    @PutMapping("/{name}/objects/{objectName}")
    public ResponseEntity<String> updateObject(@PathVariable("name") String name, @PathVariable("objectName") String objectName,ObjectOperationInfo objectOperationInfo) {
        return ResponseEntity.ok("Object edit successfully");
    }

    //오브젝트 삭제
    @DeleteMapping("/{name}/objects/{objectName}")
    public ResponseEntity<String> deleteObject(@PathVariable("name") String name, @PathVariable("objectName") String objectName,ObjectOperationInfo objectOperationInfo) {
        return ResponseEntity.ok("Object delete successfully");
    }

    //오브젝트 다운로드
    @GetMapping("/{name}/objects/{objectName}/download")
    public ResponseEntity<String> downloadObject(@PathVariable("name") String name, @PathVariable("objectName") String objectName,ObjectOperationInfo objectOperationInfo) {
        return ResponseEntity.ok("Object download successfully");
    }
}
