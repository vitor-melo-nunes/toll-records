#!/bin/bash

# Create SNS Topic
docker exec -it localstack aws --endpoint-url=http://localhost:4566 sns create-topic --name toll-records-created --region sa-east-1

# Create SQS Topic
docker exec -it localstack aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name toll-records-payment-pending-queue --region sa-east-1

# Subscriber SQS in SNS
docker exec -it localstack aws --endpoint-url=http://localhost:4566 sns subscribe --topic-arn arn:aws:sns:sa-east-1:000000000000:toll-records-created --protocol sqs --notification-endpoint arn:aws:sqs:sa-east-1:000000000000:toll-records-payment-pending-queue --region sa-east-1

# Purge SQS
docker exec -it localstack awslocal sqs purge-queue --queue-arn arn:aws:sqs:sa-east-1:000000000000:toll-records-payment-pending-queue