# SpringSecurity_JWT
# Simple Example of Spring Security and JWT

# Build:
mvn clean install

# Run: 
mvn spring-boot:run

# issues a GET request to retrieve tournaments with no JWT
# HTTP 403 Forbidden status is expected
curl http://localhost:8080/tournaments

# registers a new user
curl -H "Content-Type: application/json" -X POST -d '{
    "username": "admin",
    "password": "password"
}' http://localhost:8080/users/sign-up

# logs into the application (JWT is generated)
curl -i -H "Content-Type: application/json" -X POST -d '{
    "username": "Andre Akkary",
    "password": "AllIn"
}' http://localhost:8080/login

# issue a POST request, passing the JWT, to create a task
# remember to replace xxx.yyy.zzz with the JWT retrieved above
curl -H "Content-Type: application/json" \
-H "Authorization: Bearer xxx.yyy.zzz" \
-X POST -d '{
	"name": "Andre Akkary",
    "country": "Brazil"
}'  http://localhost:8080/tournaments

# issue a new GET request, passing the JWT
# remember to replace xxx.yyy.zzz with the JWT retrieved above
curl -H "Authorization: Bearer xxx.yyy.zzz" http://localhost:8080/tournaments
