# 협업 컨벤션

이 프로젝트의 브랜치 전략과 커밋 메시지 규칙이다. 모든 작업은 이 문서를 기준으로 한다.

## 1. 브랜치 전략

```
이슈 만들기 → dev에서 이슈별 브랜치 따기 → 작업 → PR → dev → PR → main

feature/40 ─┐
fix/45     ─┼──► PR (squash merge) ──► dev ──► PR (merge commit) ──► main
docs/60    ─┘                          개발 환경                     운영
```

- 오래 유지하는 브랜치는 `main`(운영)과 `dev`(개발 환경) 두 개다.
- 둘 다 직접 커밋하지 않고, 항상 PR로만 합친다.
- 작업 순서: 이슈를 만들고, `dev`에서 이슈별 브랜치를 따서 작업한 뒤 `dev`로 PR을 보낸다. `dev`에 모인 코드는 따로 PR을 보내 `main`에 합친다.
- 병합 방식: 작업 브랜치 → `dev`는 squash merge로 합쳐 PR 하나가 커밋 하나로 남게 한다. `dev` → `main`은 일반 병합(Create a merge commit)으로 합친다. squash로 합치면 `main`과 `dev`의 이력이 갈라져 다음 반영 때 이미 반영한 커밋이 다시 보이거나 충돌이 난다.
- 브랜치 이름은 `<유형>/<이슈번호>` 형식이다. `#`이나 한글 설명은 붙이지 않는다.

| 브랜치 | 커밋 유형 | 이슈 라벨 | 예 |
|---|---|---|---|
| `feature/` | `Feat` | `type: feat` | `feature/40` |
| `fix/` | `Fix` | `type: bug` | `fix/45` |
| `docs/` | `Docs` | `type: docs` | `docs/60` |
| `refactor/` | `Refactor` | `type: refactor` | `refactor/62` |
| `test/` | `Test` | `type: test` | `test/70` |
| `chore/` | `Chore` | `type: chore` | `chore/71` |
| `design/` | `Design` | `type: design` | `design/72` |

## 2. 커밋 메시지 규칙

```text
<Type>: <제목>

- 변경 내용 1
- 변경 내용 2

Ref: #이슈번호
```

- **유형**: 영어로 쓰고 첫 글자는 대문자다. 아래 중에서 고른다.
  `Feat`, `Fix`, `Docs`, `Style`, `Refactor`, `Test`, `Chore`, `Design`, `Comment`, `Rename`, `Remove`, `!BREAKING CHANGE`, `!HOTFIX`
- **제목**: 한글로 쓴다. 끝에 `.`을 붙이지 않고, 영문 기준 50자 이내로 쓴다.
- **본문**: 한글로, 글머리표(`-`)를 써서 무엇을 왜 바꿨는지 적는다. 파일 목록은 넣지 않는다.
- **꼬리말**: `Ref: #이슈번호`를 쓴다. 이슈가 여러 개면 한 줄에 하나씩 쓴다.
- 제목 끝에 `(#N)`을 직접 쓰지 않는다. squash merge 때 GitHub이 PR 번호를 붙여 준다.
- 성격이 다른 변경(문서, 기능, 시험 등)은 커밋을 나눈다.
- `.env`, 비밀번호, 토큰은 커밋하지 않는다. `.env.example`만 올린다.
- AI 표기(`Co-Authored-By: Claude ...`, `🤖 Generated with ...`)는 커밋과 PR 어디에도 넣지 않는다.

```text
// 좋은 예
Feat: 회원가입 시 이메일 인증 기능 추가

- 인증 코드 발송 API 추가
- 인증 코드 입력 화면 추가

Ref: #1

// 나쁜 예
feat: 주문→정산 구매확정 이벤트 DTO 정의             ← 유형이 소문자
[지갑] Wallet 도메인 및 지갑 생성 구현 (#51)         ← 대괄호 도메인, 번호 직접 씀
```

## 3. 이슈와 PR

### 이슈

- 이슈는 템플릿(`.github/ISSUE_TEMPLATE`)으로 만든다. 템플릿을 고르면 라벨이 자동으로 붙는다.
- 제목은 `[도메인] 설명` 형식이다. 예: `[order] 주문 취소 시 금액 오류`
  - 특정 도메인에 속하지 않으면 `[common]`, 인프라·설정 작업이면 `[infra]`를 쓴다.

| 템플릿 | 라벨 | 브랜치 |
|---|---|---|
| ✨ 기능 추가 | `type: feat` | `feature/<번호>` |
| 🐞 버그 제보 | `type: bug` | `fix/<번호>` |
| ♻️ 리팩터링 | `type: refactor` | `refactor/<번호>` |
| 📝 문서 | `type: docs` | `docs/<번호>` |
| ⚙️ 설정·기타 | `type: chore` | `chore/<번호>` |

### PR

- 기준 브랜치는 `dev`다.
- 제목은 커밋 제목과 같은 `<Type>: <제목>` 형식이다. squash merge 때 이 제목이 커밋 제목이 된다.
- 본문은 PR 템플릿(`.github/PULL_REQUEST_TEMPLATE.md`)을 따르고, `Closes #이슈번호`로 이슈를 연결한다.
- PR 본문에 AI 표기(`🤖 Generated with ...`)를 넣지 않는다.
