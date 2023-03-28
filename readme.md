# BackEnd Api

## User

### Add User

**method:** Post

**path:**`/user/add`

#### param

1. name
2. password
3. email
4. tel
5. address

**return on success:** uid

### Auth

**method:** Post

**path:** `/user/auth`

#### param

1. name
2. password

**return on success:** uid

**return on failure** TODO

### Search

**method:** Post

**path:** `/user/search`

#### param

1. uid

**return on success:** `{uid:1, name:lhq, ...}`

**return on failure** TODO

### get all user

**method:** Post

**path:** `/user/all`

#### param

none

**return on success:** `[{uid:1, name:lhq, ...},...]`

**return on failure** TODO

## Book

### Add Book

**method:** Post

**path:**`/book/add`

#### param

1. name
2. author
3. price

**return on success:** bookId

### Get All Books

**method:** Get

**path:**`/book/all`

#### param

none

**return on success**:`[{'bookId'=1, 'name'='病隙碎笔','author'='史铁生','price'='22.5'},...]`

### Get Book By Id

**method:** Post

**path:**`/book/search`

#### param

1. bookId

**return on success:** bookId `{'bookId'=1, 'name'='病隙碎笔','author'='史铁生','price'='22.5'}`
 