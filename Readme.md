Important commands:


//DB Server
docker compose -f docker-compose.db.yml up -d


//Application server
docker compose -f docker-compose.app.yml up --build

//To Down services

docker compose -f docker-compose.db.yml down
docker compose -f docker-compose.app.yml down
