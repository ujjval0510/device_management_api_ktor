## Upload Ktor app in heroku
pre-deployment setup
1. git remote
2. git remote -v
3. brew install gradle
4. gradle wrapper
5. In app build.gradle add below lines after plugins
   tasks.create("stage") {
   dependsOn("installDist")
   }

## Steps for upload Ktor app in heroku

1. install heroku from terminal using below command
   - brew tap heroku/brew && brew install heroku

2. Go to project terminal and execute below command
    - heroku login
3. create app
    - heroku create
4. After that install DB plugin using below command
    - heroku addons:create jawsdb

5. heroku mysql url, so for that we need to execute below cmd.
    - heroku config:get JAWSDB_URL
      after this we will receive long url (like aws url)

   URL format : ---user_name--@---password--@---host----:port_number/database_name

   Copy that url and paste it in our code where we written url after mysql:

6. Run application that succecssfully connected with db.

7. Create new mysql connection with above db credential

8. use heroku database and create tables in that. 
    USE database_name
    create all tables

