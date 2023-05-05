## 토큰 유효기간 검증

---

- 어떠한 API 통신을 하는데에 있어 토큰이 있어야 통신할 수 있다.
- 토큰은 요청 api를 통해 발급받을 수 있으며, 10초동안 동안 유효하다. (기준은 expired 확인)
- API는 테스트용 사이트를 통해 하되, 토큰발급은 자체적으로 구현한다.

---
테스트용 API - https://jsonplaceholder.typicode.com/