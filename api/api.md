FORMAT: 1A

# Sense API
An API that interacts with the Sense Services.

## Conventions

### 1. Request Identification
- Every request requires a client id. This is passed in the request header with key "clientId".
- Requests may pass in a correlation id. This is passed in the request header with key "correlationId".  If this is not passed one will be generated. The value, is returned in the response header.

- Example request header values:

  {
      Accept: application/json
      correlationId: test1
      clientId: myclient
  }

### 2. Security
- Security is implemented by using a combination of SSL and Basic Authorization.  The authorization is passed in the request header.

- Example request header values with authorization

    {
       Accept: application/json
       correlationId: test1
       clientId: myclient
       Authorization: Basic YnJpYW5lbm9jaDpzZWNyZXQ=
    }


### 3. Versioning
- The entire API will be versioned as a unit.
- Deprecated versions will be supported for 3 months.
- A version increment indicates a breaking change to existing functionality.


### 4. Schema
- This document serves as the primary documentation for all service endpoints, including data model. It is available as HTML and JSON (in the [Blueprint](http://apiblueprint.org/) format).
- All dates and times are [ISO 8601](http://www.w3.org/TR/NOTE-datetime) in the GMT zone (Z).
- The Content-Type header [SHOULD](http://www.ietf.org/rfc/rfc2119.txt) be included in all requests and responses. Possible exceptions:
    1. The request portion of a GET
    2. Responses that legitimately have no body (in which case a very specific status code SHOULD be used, for example 204 No Content)

### 5. HTTP Status Codes

| Status | Description | Notes |
| ------ | ----------- | ----- |
| 200 | Success | |
| 202 | Accepted | Warning: acknowledges receipt but not necessarily success |
| 301 | Moved Permanently | |
| 303 | See Other | Temporary redirect switching to GET |
| 307 | Temporary Redirect | Temporary redirect preserving original verb |
| 400 | Bad Request | |
| 401 | Unauthorized | Reserved for future use |
| 403 | Forbidden | Reserved for future use |
| 404 | Not Found | |
| 405 | Method Not Found | |
| 415 | Unsupported Media Type | |
| 429 | Too Many Requests | |
| 500 | Internal Server Error | |
| 502 | Bad Gateway | |
| 503 | Service Unavailable | |
| 504 | Gateway Timeout | |

### 6. HTTP Methods
In the event that a client is unable to support any of the following methods.

| Method  | |
| ------- | |
| GET     | Retrieval of resources  |
| POST    | Insertion of resources  |
| PUT     | Update of resource      |
| DELETE  | Deletion of resources   |
| PATCH   | Reserved for future use |

## 7. Resources

# Group Email
Operations related to Email resources

## Email [/email]

### Retrieves All Email Record [GET]
+ Request
    + Headers
        Content-Type: application/json
        correlationId: correlationId
        clientId: clientId
        Authorization: Basic YnJpYW5lbm9jaDpzZWNyZXQ=
    + Body
        {
        }
+ Response 200 (application/json)
    + Body
        {[
            {
                "id": "bfb0e54d-7f5f-4bfd-9199-0154e37a46b7",
                "emailAddress": "brian.enochson@gmail.com",
                "entityType": "U",
                "emailType": "U",
                "enabled": "1",
                "createDate": "2014-08-25T03:06:04+0000",
                "updateDate": null
            }
            {
                "id": "7d0b6ebe-e7dc-471d-abfc-d60474e489ac",
                "emailAddress": "brian.enochson@yahoo.com",
                "entityType": "H",
                "emailType": "W",
                "enabled": "1",
                "createDate": "2014-08-25T03:06:04+0000",
                "updateDate": null
            }
        ]}
+ Response 400 (application/json)
    + Body
        {
            "status": 400,
            "type": "Error",
            "code": "MISSED_REQUIRED_PROPERTY",
            "message": "Missing required property: emailAddress"
        }
+ Response 401 (application/json)
    + Body
        {
            "status": "401",
            "type": "Error",
            "code": "CLIENTID_NOT_PRESENT",
            "message": "Client Id Not Sent With Request"
        }
+ Response 500 (application/json)
    + Body
        {
            "status": 500,
            "type": "Error",
            "code": "INTERNAL_SERVER_ERROR",
            "message": "Internal Server Error"
        }
                
### Insert an Email Record [POST]
+ Request
    + Headers
        Content-Type: application/json
        correlationId: correlationId
        clientId: clientId
        Authorization: Basic YnJpYW5lbm9jaDpzZWNyZXQ=
    + Body
        {
            "emailAddress": "brian.enochson@gmail.com",
            "entityType": "C",
            "emailType": "W"
        }
+ Response 200 (application/json)
    + Body
        {
            "id": "bfb0e54d-7f5f-4bfd-9199-0154e37a46b7",
            "emailAddress": "brian.enochson@gmail.com",
            "entityType": "C",
            "emailType": "W",
            "enabled": "1",
            "createDate": "2014-08-25T03:06:04+0000",
            "updateDate": null
        }
+ Response 400 (application/json)
    + Body
        {
            "status": 400,
            "type": "Error",
            "code": "MISSED_REQUIRED_PROPERTY",
            "message": "Missing required property: emailAddress"
        }
+ Response 401 (application/json)
    + Body
        {
            "status": 401,
            "type": "Error",
            "code": "CLIENTID_NOT_PRESENT",
            "message": "Client Id Not Sent With Request"
        }
+ Response 500 (application/json)
    + Body
        {
            "status": 500,
            "type": "Error",
            "code": "INTERNAL_SERVER_ERROR",
            "message": "Internal Server Error"
        }

# Group Authorized Entity
Operations related to Authorized Entity. This is a consumer or vendor that has security information stored in the system.

## Authorized Entity [/secure/entity/credentials]

### Retrieves an Authorized Entity [GET]
+ Request
    + Headers
        Content-Type: application/json
        correlationId: correlationId
        clientId: clientId
        Authorization: Basic YnJpYW5lbm9jaDpzZWNyZXQ=
    + Body
        {
        }
+ Response 200 (application/json)
    + Body
        {
            "auId": "53191101-1263-44bf-826e-b59b06f503b2",
            "entityId": "559a15c7-4616-44e2-b304-fc58570a6ddc",
            "username": "brianenoch4",
            "hashPass": "",
            "plaintextPass": "",
            "token": "a8a0132f-e9d5-42e1-9db5-1600942afe03",
            "enabled": 1,
            "createDate": "2014-08-25T03:06:04+0000",
            "entity": {
                "id": "559a15c7-4616-44e2-b304-fc58570a6ddc",
                "entityType": "C",
                "firstName": "Brian",
                "lastName": "Consumer",
                "addressLine1": "1013 Curtis Avenue",
                "addressLine2": "Suite 202",
                "city": "Point Pleasant",
                "state": "NJ",
                "zip": "08742",
                "country": "USA",
                "businessName": "acme inc",
                "businessDescription": "acme inc desc",
                "businessWebsite": "www.acme.com",
                "accountStatus": "ACTIVE",
                "createDate": "2014-08-25T03:06:04+0000",
                "updateDate": "2014-08-25T03:06:04+0000",
                "emails": [
                    {
                        "id": "e815e652-e37e-4785-9e7a-163afcf37482",
                        "entityId": "559a15c7-4616-44e2-b304-fc58570a6ddc",
                        "emailAddress": "brian.enochson@icloud.com",
                        "entityType": "U",
                        "emailType": "U",
                        "enabled": 1,
                        "createDate": "2014-08-25T03:06:04+0000",
                        "updateDate": "2014-08-25T03:06:04+0000"
                    }
                ],
                "phones": [
                    {
                        "id": "0b8b6f60-dba6-40dd-a8c1-2f6efc1ba309",
                        "entityId": "559a15c7-4616-44e2-b304-fc58570a6ddc",
                        "phoneNumber": "2022159661",
                        "entityType": "C",
                        "phoneType": "C",
                        "enabled": 1,
                        "createDate": "2014-08-25T03:06:04+0000",
                        "updateDate": "2014-08-25T03:06:04+0000"
                    }
                ]
            }
        }
+ Response 400 (application/json)
    + Body
        {
            "status": 400,
            "type": "Error",
            "code": "MISSED_REQUIRED_PROPERTY",
            "message": "Missing required property: emailAddress"
        }
+ Response 401 (application/json)
    + Body
        {
            "status": "401",
            "type": "Error",
            "code": "CLIENTID_NOT_PRESENT",
            "message": "Client Id Not Sent With Request"
        }
+ Response 500 (application/json)
    + Body
        {
            "status": 500,
            "type": "Error",
            "code": "INTERNAL_SERVER_ERROR",
            "message": "Internal Server Error"
        }
                
### Insert an Authorized Entity [POST]
+ Request
    + Headers
        Content-Type: application/json
        correlationId: correlationId
        clientId: clientId
        Authorization: Basic YnJpYW5lbm9jaDpzZWNyZXQ=
    + Body
        {
             "username": "brianenoch4",
             "plaintextPass": "secret",
             "enabled": "1",
             "entity": {
                 "firstName": "Brian",
                 "entityType":"C",
                 "lastName": "Consumer",
                 "addressLine1": "1013 Curtis Avenue",
                 "addressLine2": "Suite 202",
                 "city": "Point Pleasant",
                 "state": "NJ",
                 "zip": "08742",
                 "country": "USA",
                 "accountStatus": "ACTIVE",
                 "emails": [
                      {
                          "emailAddress": "brian.enochson@icloud.com",
                          "entityType": "U",
                          "emailType": "U",
                          "enabled": "1"
                      }
                 ],
                 "phones": [
                      {
                          "phoneNumber": "2022159661",
                          "entityType": "C",
                          "phoneType": "C",
                          "enabled": "1"
                      }
                 ]
             }
        }
+ Response 200 (application/json)
    + Body
        {
            "auId": "7d7628db-3639-4c2c-a22d-5d1e4474191d",
            "entityId": "3e7750fc-4b7e-43ec-93e1-d76ab1f1badb",
            "username": "brianenoch4",
            "hashSalt": "",
            "hashPass": "",
            "plaintextPass": "",
            "token": null,
            "enabled": 1,
            "createDate": "2014-08-26T04:08:31+0000",
            "updateDate": null,
            "entity": {
                "id": "3e7750fc-4b7e-43ec-93e1-d76ab1f1badb",
                "entityType": "C",
                "firstName": "Brian",
                "lastName": "Consumer",
                "addressLine1": "1013 Curtis Avenue",
                "addressLine2": null,
                "city": "Point Pleasant",
                "state": "NJ",
                "zip": "08742",
                "country": "USA",
                "businessName": null,
                "businessDescription": null,
                "businessWebsite": null,
                "accountStatus": "ACTIVE",
                "createDate": "2014-08-26T04:08:31+0000",
                "updateDate": null,
                "emails": [
                    {
                        "id": "4fd3141f-bcb5-4beb-88ca-631f4893205d",
                        "entityId": "3e7750fc-4b7e-43ec-93e1-d76ab1f1badb",
                        "emailAddress": "brian.enochson@icloud.com",
                        "entityType": "U",
                        "emailType": "U",
                        "enabled": 1,
                        "createDate": "2014-08-26T04:08:31+0000",
                        "updateDate": null
                    }
                ],
                "phones": [
                    {
                        "id": "1b35693b-20ba-4c94-8408-cb30aafbc0b9",
                        "entityId": "3e7750fc-4b7e-43ec-93e1-d76ab1f1badb",
                        "phoneNumber": "2022159661",
                        "entityType": "C",
                        "phoneType": "C",
                        "enabled": 1,
                        "createDate": "2014-08-26T04:08:31+0000",
                        "updateDate": null
                    }
                ]
            }
        }
+ Response 400 (application/json)
    + Body
        {
            "status": 400,
            "type": "Error",
            "code": "MISSED_REQUIRED_PROPERTY",
            "message": "Missing required property: emailAddress"
        }
+ Response 401 (application/json)
    + Body
        {
            "status": 401,
            "type": "Error",
            "code": "CLIENTID_NOT_PRESENT",
            "message": "Client Id Not Sent With Request"
        }
+ Response 500 (application/json)
    + Body
        {
            "status": 500,
            "type": "Error",
            "code": "INTERNAL_SERVER_ERROR",
            "message": "Internal Server Error"
        }
            
### Update an Authorized Entity [PUT]
+ Request
    + Headers
        Content-Type: application/json
        correlationId: correlationId
        clientId: clientId
        Authorization: Basic YnJpYW5lbm9jaDpzZWNyZXQ=
    + Body
        {
             "auId": "2867ce96-4b97-4762-8577-43d58d90cb38",
             "entityId": "94a80e22-eac8-40df-9580-66de2b6821c5",
             "username": "brianenoch4",
             "plaintextPass": "secret",
             "enabled": "1",
             "createDate": "2014-08-25T02:33:53+0000",
             "entity": {
                 "id": "94a80e22-eac8-40df-9580-66de2b6821c5",
                 "firstName": "Brian",
                 "entityType":"C",
                 "lastName": "Consumer2",
                 "addressLine1": "1013 Curtis Avenue",
                 "addressLine2": null,
                 "city": "Mannesquan",
                 "state": "NJ",
                 "zip": "08742",
                 "country": "USA",
                 "accountStatus": "ACTIVE",
                 "createDate": "2014-08-25T02:33:53+0000",
                 "emails":[
                     {
                         "id": "9697022d-e10f-493b-b547-595d4a727e49",
                         "entityId": "94a80e22-eac8-40df-9580-66de2b6821c5",
                         "emailAddress": "brian.enochson@hbo.com",
                         "entityType": "C",
                         "emailType": "W",
                         "enabled": "1",
                         "createDate": "2014-08-25T02:33:53+0000"
                     }
                 ],
                 "phones":[
                     {
                         "id": "e3d00a67-fa7f-48e9-902b-fd40629fb681",
                         "entityId": "94a80e22-eac8-40df-9580-66de2b6821c5",
                         "phoneNumber": "2022159661",
                         "entityType": "C",
                         "phoneType": "C",
                         "enabled": "1",
                         "createDate": "2014-08-25T02:33:53+0000"
                     }
                 ]
             }
        }
+ Response 200 (application/json)
    + Body
        {
            "auId": "7d7628db-3639-4c2c-a22d-5d1e4474191d",
            "entityId": "3e7750fc-4b7e-43ec-93e1-d76ab1f1badb",
            "username": "brianenoch4",
            "hashSalt": null,
            "hashPass": "",
            "plaintextPass": "",
            "token": null,
            "enabled": 1,
            "createDate": "2014-08-26T04:08:31+0000",
            "updateDate": null,
            "entity": {
                "id": "3e7750fc-4b7e-43ec-93e1-d76ab1f1badb",
                "entityType": "C",
                "firstName": "Brian",
                "lastName": "Consumer",
                "addressLine1": "1013 Curtis Avenue",
                "addressLine2": null,
                "city": "Point Pleasant",
                "state": "NJ",
                "zip": "08742",
                "country": "USA",
                "businessName": null,
                "businessDescription": null,
                "businessWebsite": null,
                "accountStatus": "ACTIVE",
                "createDate": "2014-08-26T04:08:31+0000",
                "updateDate": null,
                "emails":
                [
                    {
                        "id": "4fd3141f-bcb5-4beb-88ca-631f4893205d",
                        "entityId": "3e7750fc-4b7e-43ec-93e1-d76ab1f1badb",
                        "emailAddress": "brian.enochson@icloud.com",
                        "entityType": "U",
                        "emailType": "U",
                        "enabled": 1,
                        "createDate": "2014-08-26T04:08:31+0000",
                        "updateDate": null
                    }
                ],
                "phones":
                [
                    {
                        "id": "1b35693b-20ba-4c94-8408-cb30aafbc0b9",
                        "entityId": "3e7750fc-4b7e-43ec-93e1-d76ab1f1badb",
                        "phoneNumber": "2022159661",
                        "entityType": "C",
                        "phoneType": "C",
                        "enabled": 1,
                        "createDate": "2014-08-26T04:08:31+0000",
                        "updateDate": null
                    }
                ]
            }
        }
+ Response 400 (application/json)
    + Body
        {
            "status": 400,
            "type": "Error",
            "code": "MISSED_REQUIRED_PROPERTY",
            "message": "Missing required property: emailAddress"
        }
+ Response 401 (application/json)
    + Body
        {
            "status": 401,
            "type": "Error",
            "code": "CLIENTID_NOT_PRESENT",
            "message": "Client Id Not Sent With Request"
        }
+ Response 500 (application/json)
    + Body
        {
            "status": 500,
            "type": "Error",
            "code": "INTERNAL_SERVER_ERROR",
            "message": "Internal Server Error"
        }

# Group Consumer
Consumer specific operations

## Consumer [/secure/consumer/]

### Retrieves a Consumer Entity  [GET]
+ Parameters
    + id (string) ... ID of the consumer to be retrieved.        
+ Request
    + Headers
        Content-Type: application/json
        correlationId: correlationId
        clientId: clientId
        Authorization: Basic YnJpYW5lbm9jaDpzZWNyZXQ=
    + Body
        {
        }
+ Response 200 (application/json)
    + Body
        {
            "id": "94a80e22-eac8-40df-9580-66de2b6821c5",
            "entityType": "C",
            "firstName": "Brian",
            "lastName": "Consumer2",
            "addressLine1": "1013 Curtis Avenue",
            "addressLine2": null,
            "city": "Mannesquan",
            "state": "NJ",
            "zip": "08742",
            "country": "USA",
            "businessName": null,
            "businessDescription": null,
            "businessWebsite": null,
            "accountStatus": "ACTIVE",
            "createDate": "2014-08-25T02:33:53+0000",
            "updateDate": null,
            "emails": null,
            "phones": null,
            "consumerAccounts": null,
            "needs": null
        }       

+ Response 400 (application/json)
    + Body
        {
            "status": 400,
            "type": "Error",
            "code": "MISSED_REQUIRED_PROPERTY",
            "message": "Missing required property: emailAddress"
        }
+ Response 401 (application/json)
    + Body
        {
            "status": 401,
            "type": "Error",
            "code": "CLIENTID_NOT_PRESENT",
            "message": "Client Id Not Sent With Request"
        }
+ Response 500 (application/json)
    + Body
        {
            "status": 500,
            "type": "Error",
            "code": "INTERNAL_SERVER_ERROR",
            "message": "Internal Server Error"
        }

### Updates a Consumer  [PUT]

+ Request
    + Headers
        Content-Type: application/json
        correlationId: correlationId
        clientId: clientId
        Authorization: Basic YnJpYW5lbm9jaDpzZWNyZXQ=
    + Body
        {
            "id": "94a80e22-eac8-40df-9580-66de2b6821c5",
            "entityType": "C",
            "firstName": "Brian",
            "lastName": "Consumer2",
            "addressLine1": "1013 Curtis Avenue",
            "addressLine2": null,
            "city": "Mannesquan",
            "state": "NJ",
            "zip": "08742",
            "country": "USA",
            "businessName": null,
            "businessDescription": null,
            "businessWebsite": null,
            "accountStatus": "ACTIVE",
            "createDate": "2014-08-25T02:33:53+0000",
            "emails": [
                {
                    "id": "f61b5889-8a11-4d71-b1c1-312cde9ee9cc",
                    "transactionType": "D"
                }
            ],
            "phones": [
                {
                    "id": "06261dc5-bd67-4bbe-a8d9-97fea531bb81",
                    "transactionType": "D"
                }
            ]
        }
+ Response 200 (application/json)
    + Body
        {
            "id": "94a80e22-eac8-40df-9580-66de2b6821c5"
            "entityType": "C"
            "firstName": "Brian"
            "lastName": "Consumer2"
            "addressLine1": "1013 Curtis Avenue"
            "addressLine2": null
            "city": "Mannesquan"
            "state": "NJ"
            "zip": "08742"
            "country": "USA"
            "businessName": null
            "businessDescription": null
            "businessWebsite": null
            "accountStatus": "ACTIVE"
            "createDate": "2014-08-25T02:33:53+0000"
            "updateDate": null
            "emails": null
            "phones": null
            "consumerAccounts": null
            "needs": [0]
        }                
+ Response 400 (application/json)
    + Body
        {
            "status": 400,
            "type": "Error",
            "code": "MISSED_REQUIRED_PROPERTY",
            "message": "Missing required property: emailAddress"
        }
+ Response 401 (application/json)
    + Body
        {
            "status": 401,
            "type": "Error",
            "code": "CLIENTID_NOT_PRESENT",
            "message": "Client Id Not Sent With Request"
        }
+ Response 500 (application/json)
    + Body
        {
            "status": 500,
            "type": "Error",
            "code": "INTERNAL_SERVER_ERROR",
            "message": "Internal Server Error"
        }
        
### Inserts a Consumer Account Entry  [POST]
+ Parameters
    + id (string) ... ID of the consumer to be retrieved.   
    + account (string) ...account fixed portion
+ Request
    + Headers
        Content-Type: application/json
        correlationId: correlationId
        clientId: clientId
        Authorization: Basic YnJpYW5lbm9jaDpzZWNyZXQ=
    + Body
        {
            "owner": "CONSUMER",
            "value": 500,
            "status": "AVAILABLE",
            "currency": "USD"
        }
+ Response 200 (application/json)
    + Body
        {
            id: "148febb9-1004-4715-ad84-f8f7694aac41"
            entityId: "94a80e22-eac8-40df-9580-66de2b6821c5"
            owner: "CONSUMER"
            value: 500
            status: "AVAILABLE"
            currency: "USD"
            createDate: "2014-08-27T04:00:55+0000"
            updateDate: null
        }
+ Response 400 (application/json)
    + Body
        {
            "status": 400,
            "type": "Error",
            "code": "MISSED_REQUIRED_PROPERTY",
            "message": "Missing required property: emailAddress"
        }
+ Response 401 (application/json)
    + Body
        {
            "status": 401,
            "type": "Error",
            "code": "CLIENTID_NOT_PRESENT",
            "message": "Client Id Not Sent With Request"
        }
+ Response 500 (application/json)
    + Body
        {
            "status": 500,
            "type": "Error",
            "code": "INTERNAL_SERVER_ERROR",
            "message": "Internal Server Error"
        }
