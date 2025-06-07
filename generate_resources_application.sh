#!/bin/bash

PACKAGE_NAME="com.latinhouse.backend"
PACKAGE_PATH="com/latinhouse/backend"

BASE_DIR="./src/main/resources"

echo "📁 생성 중: resoures.application"

mkdir -p $BASE_DIR

# application.yml
cat <<EOF > $BASE_DIR/application.yml
spring:
  profiles:
    active: dev
    include: secret
  jpa:
    hibernate:
      ddl-auto: create
    properties:
      hibernate:
        show-sql: true
        format_sql: true
        use_sql_comments: true
logging:
  level:
    root: INFO
    com.springnext.demo: DEBUG
    org.hibernate.orm.jdbc.bind: TRACE
    org.hibernate.orm.jdbc.extact: TRACE

# Swagger springdoc-ui Configuration
springdoc:
  packages-to-scan:
    - ${PACKAGE_NAME}.user.adapter.in.web
  default-consumes-media-type: application/json;charset=UTF-8
  default-produces-media-type: application/json;charset=UTF-8
  swagger-ui:
    path: /swagger-ui.html
    tags-sorter: alpha
    operations-sorter: alpha
  api-docs:
    path: /v3/api-docs
    groups:
      enabled: true
  cache:
    disabled: true
EOF

# application-dev.yml
cat <<EOF > $BASE_DIR/application-dev.yml
server:
  port: 8080
spring:
  output:
    ansi:
      enabled: always
  datasource:
    url: jdbc:h2:mem:test
    username: sa
    password:
    driver-class-name: org.h2.Driver
  h2:
    console:
      enabled: true
custom:
  fileDirPath: ./files
EOF

# application-prod.yml
cat <<EOF > $BASE_DIR/application-prod.yml
custom:
  fileDirPath: /usr/file
EOF

# application-secret.yml.default
cat <<EOF > $BASE_DIR/application-secret.yml.default
spring:
  security:
    oauth2:
      client:
        registration:
          kakao:
            client-id: YOUR_KAKAO_REST_API_KEY
            redirect-uri: "{baseUrl}/login/oauth2/code/kakao"
            authorization-grant-type: authorization_code
            scope: profile_nickname, account_email
        provider:
          kakao:
            authorization-uri: https://kauth.kakao.com/oauth/authorize
            token-uri: https://kauth.kakao.com/oauth/token
            user-info-uri: https://kapi.kakao.com/v2/user/me
            user-name-attribute: id
custom:
  jwt:
    secretKey: secret-key (longer than 32)
EOF

echo "✅ global.exception 생성 완료"
