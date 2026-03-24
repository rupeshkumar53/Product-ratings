# Product-ratings
## 📖 About  
**Product Ratings Service** is a standalone microservice that handles all product review and rating operations. Users can submit ratings (1–5 stars) with optional reviews for any product. The service exposes REST APIs consumed via **API Gateway**, and registers itself with **Eureka Server** for service discovery.

## ✨ Features

- ✅ Submit product ratings with review description
- ✅ Fetch all ratings for a specific product
- ✅ Fetch all ratings given by a specific user
- ✅ Calculate average rating of a product
- ✅ Delete a rating
- ✅ Eureka Client — Auto registers with Service Discovery
- ✅ MySQL database integration via Spring Data JPA
- ✅ Clean REST API design
- ✅ Input validation (`@Min`, `@Max` on rating field)

## 🏗 Architecture
Client Request
      │
      ▼
┌─────────────────┐
│   API Gateway   │  :9094
│  (Entry Point)  │
└────────┬────────┘
         │
         ▼
┌─────────────────┐       ┌──────────────────┐
│  Eureka Server  │◄──────│ Product Ratings  │
│ (Discovery :9090)│      │  Service :9091   │  
└─────────────────┘       └────────┬─────────┘
                                   │
                                   ▼
                          ┌─────────────────┐
                          │  MySQL Database │
                          │  ratings_db     │
                          └─────────────────┘

## 👨‍💻 Author

**Rupesh Kumar**
- 💼 Java Developer | Spring Boot | Microservices
- 📍 Noida, India
- 🔗 [LinkedIn]([https://linkedin.com/in/your-profile](https://www.linkedin.com/in/rupesh-kumar-92a680229/))
