# Sector Select - Backend

The backend part of the Sector Select application.  
A Spring Boot application with REST APIs to manage **Users** and **Sectors**.

Database is **PostgreSQL** and **Liquibase** for schema and data migration.

---

## Prerequisites

- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/install/)

---

## How to Run

1. Clone the repository:

   ```bash
   git https://github.com/killu-k/sector-select.git
   ```
   
2. Build and start the application and db (in projects root dir):

   ```bash
   docker compose up --build
   ```
   
## API endpoints

- Base URL: http://localhost:8080/api
- GET /api/sectors - get all sectors
- POST /api/users - create user
- PUT /api/users/me - update user
- GET /api/users/me - get session user

## Configurations

Default configs are in application.properties.

Session timeout is set to 1 minute.