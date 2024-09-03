### Users REST API
* 등록

```
  POST
  http://localhost:8080/MySpringFW/users

  header
     content-type:application/json

  body
{
    "userId": "rest",
    "name": "레스트",
    "gender": "남",
    "city": "경기"
}
```
![Insert](./image/post_insert.png)
      
* userId로 조회
```
    GET
    http://localhost:8080/MySpringFW/users/dooly

```

* 목록조회
```
    GET
    http://localhost:8080/MySpringFW/users

```

* 수정
```
    PATCH
    http://localhost:8080/MySpringFW/users/dooly

  	header
     	content-type:application/json
    
    body
      {
         "city": "대전"
      }
      
```

* 삭제
```
    DELETE
    http://localhost:8080/MySpringFW/users/dooly
```
