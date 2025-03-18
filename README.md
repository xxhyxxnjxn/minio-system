# minio-system
## MinIO 설치 및 실행

### 1) MinIO Standalone 모드 실행 (단일 노드)
로컬 개발 환경에서 테스트할 경우 아래 방법을 사용

#### (1) Docker로 실행

    docker run -p 9000:9000 -p 9090:9090 --name minio \
    -e "MINIO_ROOT_USER=admin" \
    -e "MINIO_ROOT_PASSWORD=admin123" \
    -v ~/minio/data:/data \
    quay.io/minio/minio server /data --console-address ":9090"
-p 9000:9000 → MinIO API 포트

-p 9090:9090 → MinIO 웹 콘솔 포트

-e "MINIO_ROOT_USER=admin" → 관리자 계정

-e "MINIO_ROOT_PASSWORD=admin123" → 관리자 비밀번호

#### (2) 웹 콘솔 접속

브라우저에서 http://localhost:9090 로 접속하면 MinIO 관리 콘솔이 열린다.

### 2) 분산 모드(Distributed Mode) 적용
분산 환경에서는 여러 개의 노드를 구성하고 데이터를 다중 디스크/서버에 분산 저장해야 한다.

#### 1) MinIO 분산 모드 실행 (4개 노드)
아래 명령어를 실행하면 4개의 노드를 사용하는 분산 MinIO 클러스터가 구성돼.

    docker run -p 9000:9000 -p 9090:9090 --name minio \
    -e "MINIO_ROOT_USER=admin" \
    -e "MINIO_ROOT_PASSWORD=admin123" \
    quay.io/minio/minio server http://minio{1...4}/data \
    --console-address ":9090"

이렇게 하면 minio1, minio2, minio3, minio4가 서로 연결되면서 분산 저장이 가능해진다.


코드로 다운로드 받은 파일은 프로젝트 내부에 다운받아짐
object == key
