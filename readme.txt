Напоминалочка!

REST

DELETE localhost:8080/users/id  - где  id должно быть номером удаляемого юзера

POST localhost:8080/users
в теле пишем json
{
    "username": "username",
    "userpassword": "userpassword"
}

GET localhost:8080/users?id=2
Body - none
