# SpringSecurity_JWT
# Register yourself into a Poker Tournament

# Build:
mvn clean install

# Run: 
mvn spring-boot:run

# HTTP 403 Forbidden status is expected
curl http://localhost:8080/tournaments

# Registers a new Poker Player
curl -H "Content-Type: application/json" -X POST -d '{
    "username": "admin",
    "password": "password"
}' http://localhost:8080/users/sign-up

# logs into the application (JWT is generated)
curl -i -H "Content-Type: application/json" -X POST -d '{
    "username": "Andre Akkary",
    "password": "AllIn"
}' http://localhost:8080/login

# remember to replace xxx.yyy.zzz with the JWT received above
curl -H "Content-Type: application/json" \
-H "Authorization: Bearer xxx.yyy.zzz" \
-X POST -d '{
	"name": "Andre Akkary",
    "country": "Brazil"
}'  http://localhost:8080/tournaments

# issue a new GET request, passing the JWT
# remember to replace xxx.yyy.zzz with the JWT received above
curl -H "Authorization: Bearer xxx.yyy.zzz" http://localhost:8080/tournaments
