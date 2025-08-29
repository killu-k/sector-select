# Sector Select - Backend

The backend part of the Sector Select application.  
ASpring Boot application with REST APIs to manage **Users** and **Sectors**.

Database is **PostgreSQL** and **Liquibase** for schema and data migration.

---

## Prerequisites

- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/install/)

---

## How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/YOUR_REPO/sector-select.git
   cd sector-select/backend
   ```
   
2. Build and start the application and db:

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