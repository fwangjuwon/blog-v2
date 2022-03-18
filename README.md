#블로그 v2 코드 연습

### 1. 디비 및 사용자 생성

```sql
CREATE user 'green'@'%' identified by 'green1234';
create database greendb;
GRANT ALL PRIVILEGES ON greendb.* TO 'green'@'%';
```

### 2. 프로젝트 세팅
- application.yml
- view 생성
- 
