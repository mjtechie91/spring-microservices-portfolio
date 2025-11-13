Important commands:


//DB Server
docker compose -f docker-compose.db.yml up -d


//Application server
docker compose -f docker-compose.app.yml up --build

//To Down services
//docker network create mahi

docker compose -f docker-compose.db.yml down
docker compose -f docker-compose.app.yml down
docker compose -f docker-compose.billing-app.yml up -d

docker compose -f docker-compose.kafka.yml up -d


| Access                    | URL / Address                                  | Notes                                        |
| ------------------------- | ---------------------------------------------- | -------------------------------------------- |
| Kafka from inside Docker  | `kafka:9092`                                   | Used by Kafdrop and other containers         |
| Kafka from your host (PC) | `localhost:9094`                               | Used by apps like Spring Boot, Node.js, etc. |
| Kafka UI                  | [http://localhost:9000](http://localhost:9000) | View topics/messages                         |
