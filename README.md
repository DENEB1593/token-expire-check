## 토큰 유효기간 검증

---

- 어떠한 API 통신을 하는데에 있어 토큰이 있어야 통신할 수 있다.
- 토큰은 요청 api를 통해 발급받을 수 있으며, 10초동안 동안 유효하다. (기준은 expired 확인)
- API는 테스트용 사이트를 통해 하되, 토큰발급은 자체적으로 구현한다.

---
결과: 
#### getPost 동기성(syncronized) 보장 시
 - 단일쓰레드 : 5,599ms
 - 다중쓰레드(10) : 488ms

#### getPost 동기성(syncronized) 비보장 시
- 단일쓰레드 : 4,661ms
- 다중쓰레드(10) : 85ms
  * 단, getPost의 동기성을 보장하지 않는 경우 다중쓰레드 요청시 토큰발급이 동시에 이루어져 토큰이 thread-safe하지 않는 리스크가 발견되었다


---
테스트용 API - https://jsonplaceholder.typicode.com/