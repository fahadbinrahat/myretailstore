# My Retail Store API

## Overview

This API offers capabilities to add, update, delete or retrieve online orders in RESTFul manner. It also provides foundations to add more capabilities such as adding a product, deleting a product, searching for orders for a given product etc.

## Current and Prospect(Extensions) Use-Cases

### Consumer frequently consuming API e.g. every 5 minutes..

There are couple of ways to optimise performance by managing cache on server e.g. SpringBoot caching or using another layer on infrastructure such as Akamai or API gateway.

In order to minimise load on back-end database this API uses Spring-Cache ("@EnableCaching ") component to cache response in UserService class for a pre-configured expiry time.


### Mobile application retrieving and updating order

API accepts a header called "applicationname", if the value is "mobile", consumer is identified as a mobile application hence API behaves as follows for performance optimisation and mimimal resources utilisations:

• Returns less number of records in pagination scenario. Such as 2 records per page (not implemented)

• Returns a deflated resource model instead of original canonical model(Not implemented)

• Also offers consumer option to specify required attributes of resource in response by adding them to query string.


### Adding Customer and Product Resources

The API can support 3 resources i.e. Customers, Products and Orders. These all are modelled as aggregate roots and can be identified with key attribute "id". Consumer does not need to have any other resource key when accessing a resource. 

API can be extended for following resources:-

#### /Customers
  
  Customer resource can have "Orders" resource enclosed which can in turn have "Products" resource enclosed. This relationship can be used for use-cases like:-
  
  • "Find products order by a given customer"
  
  • "Find all orders placed by a customer"

#### /Products

Products resource is an independant resource and can be used for following use cases:-
  
  • "Add a product"
  
  • "Delete a product"
  
  • "Retrieve a product"
  
  • "Update a product"
  
  • "Retreive all products"
  
  
  There can be more complex lookups as well such as GET /Orders/{productid}, which will return orders for only a given product.


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

## Implementation Details (Design Choices)

The API is developed using Spring Boot framework.

Requirement | Implementation Guide
------|------------
Security | Uses HTTPS (leverages TLS encryption) and uses Basic Auth username and password in API header (Note actual implementation of API keys, usernames, passwords is not implemented)
Resource Versioning | Uses static versioning (in route) - Other approaches such as header parameter specifying version or content-negotiation based versioning are not effective in caching scenarios
Performance optimization | Use content negotiation for mobile client using spring filters to serve compact responses. API to accept header param "applicationname" with a value such as "mobile" and accordingly produces a trimmed down resource model
Secure Parameter| No PII data in URI hence not required
JSON properties | Uses camelCase
Large Responses | Use pagination for list order resource
Cache-Control | Sets cache-control max age = 5 minutes and enable infra layer e.g. API gateway for caching and also enable Spring-Cache.

## How to do a live test ?

API is deployed on AWS EC2 instance via Elastic BeanStalk. Please import postman collection, which is provided with this repo in "/test/postman" folder, into you postman client.

