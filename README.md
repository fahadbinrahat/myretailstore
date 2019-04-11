# My Retail Store API

## Overview

This API offers capabilities to add, update, delete or retrieve online orders in RESTFul manner.

## API Source Scaffold

The source code and API design specs are kept under following organised structure.

Folder | Details
------|------------
/src/main/java | This folder contains source packages 
/src/main/resources | This folder contains application properties files and other resources
/src/test/java | This folder contains test cases
/apidoc | This folder contains swagger file
/test/postman | This folder contains postman collection.

(pom.xml contains required project dependencies)

## Implementation Details

The API is developed using Spring Boot framework.

Requirement | Implementation
------|------------
Security | Uses HTTPS (leverages TLS encryption) and uses Basic Auth username and password in API header (Note actual implementation of API keys, usernames, passwords is not implemented)
Resource Versioning | Uses static versioning (in route) - Other approaches such as header parameter specifying version or content-negotiation based versioning are not effective in caching scenarios
Performance optimization | Use content negotiation for mobile client using spring filters to serve compact responses. PI to accept header param "ACCEPTS" with a value such as vnd.mobile and accordingly produces desired content type in response
Secure Parameter| No PII data in URI hence not required
JSON properties | Uses camelCase
Large Responses | Use pagination for list order resource
Cache-Control | Sets cache-control max age = 5 minutes

## Live Testing Details

API is deployed on AWS EC2 instance via Elastic BeanStalk. Postman is provided for testing having live endpoints.
