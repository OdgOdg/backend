# 1. OpenJDK 21 기반의 경량 이미지를 사용
FROM openjdk:21-jdk-slim
# 2. 작업 디렉토리 설정
WORKDIR /app
# 3. 애플리케이션 JAR 파일 복사
COPY . .
# gradlew에 실행 권한 부여
RUN chmod +x ./gradlew
# 프로젝트 빌드
RUN ./gradlew clean build

ARG JAR_FILE=build/libs/*SNAPSHOT.jar
RUN mv ${JAR_FILE} app.jar
# 4. 컨테이너에서 실행할 명령어 설정
ENTRYPOINT ["java", "-jar", "app.jar"]
#EXPOSE 8080