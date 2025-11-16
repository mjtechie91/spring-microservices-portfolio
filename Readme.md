# Microservices Setup (Kafka + gRPC + REST)
Author: Mahenra

Important Docker Commands:
- Start DB Server:
  docker compose -f docker-compose.db.yml up -d

- Start Application Server:
  docker compose -f docker-compose.app.yml up --build

- Stop / Down Services:
  docker compose -f docker-compose.db.yml down
  docker compose -f docker-compose.app.yml down
  docker compose -f docker-compose.billing-app.yml down

- Start Billing Service:
  docker compose -f docker-compose.billing-app.yml up -d

- Start Kafka Infrastructure:
  docker compose -f docker-compose.kafka.yml up -d

- Create Docker Network:
  docker network create mahi

Kafka Access:
- Kafka inside Docker: kafka:9092
- Kafka from host: localhost:9094
- Kafka UI: http://localhost:9000

Microservices:
- analytics-service
- patient-service
- billing-service

Communication Used:
- Kafka (asynchronous events)
- gRPC (internal communication)
- REST (external API)

Service Communication:
- REST: Frontend → REST → patient-service
- gRPC: billing-service → gRPC → patient-service
  analytics-service → gRPC → patient-service
- Kafka: patient-service → Kafka → billing-service
  patient-service → Kafka → analytics-service

Event Flow Example (Patient Registration):
1. patient-service receives REST request
2. Stores data
3. Publishes Kafka event: patient.created
