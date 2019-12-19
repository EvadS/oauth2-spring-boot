db.createUser(
    {
        user: "se",
        pwd : "123456",

        roles: [
            {
                role: "readWrite",
                db  : "db"
            }
        ]
    }
)