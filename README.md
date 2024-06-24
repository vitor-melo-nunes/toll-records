# Toll Records 

The Toll Records Service is responsible for managing toll event records. It stores and retrieves toll events, ensuring they are processed correctly.

## Features
- Store toll event records
- Retrieve toll event records

## Getting Started
### Prerequisites
- Docker
- Brownser

### Build and Run
1. Run ```docker-compose up```

2. Run ```docker exec -it localstack aws --endpoint-url=http://localhost:4566 sns create-topic --name toll-records-created --region sa-east-1```

3. Run ```docker exec -it localstack aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name toll-records-payment-pending-queue --region sa-east-1```

4. Run ```docker exec -it localstack aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name toll-records-created-notifications-pending-queue --region sa-east-1```

5. Run ```docker exec -it localstack aws --endpoint-url=http://localhost:4566 sns subscribe --topic-arn arn:aws:sns:sa-east-1:000000000000:toll-records-created --protocol sqs --notification-endpoint arn:aws:sqs:sa-east-1:000000000000:toll-records-created-notifications --region sa-east-1```
