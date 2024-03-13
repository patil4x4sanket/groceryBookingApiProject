# Grocery Booking API Project

This project is a simple API for booking groceries, built with Java, Spring Boot, and Maven, can be packaged and deployed on Docker.

The beauty of this project is, you do not have to even Build this project explicity, just run docker-compose up command, and everything will be done internally.
Once the Application is up and running, the you can play around with the given Set of APIs.

----------------------------------------------------------------


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java 8
- Maven
- MySQL
- Docker
- Internet Access ;P  (atleast to Docker-Hub, to download mysql image and Public Maven Repository, to download the required maven dependencies) 


----------------------------------------------------------------


## API References

#### Fetch all items : ***GET***

```http
  GET /v1/grocery/
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Header Parameter : username` | `string` | **Required** |


Sample GET ALL URL : 
```http
http://localhost:8080/v1/grocery/

```

returns json response as below : 
```bash
[
      {
      "gId": 1,
      "gName": "Copper Bottle",
      "gPrice": 250,
      "gQuantity": 36
   },
      {
      "gId": 2,
      "gName": "Pen",
      "gPrice": 10,
      "gQuantity": 480
   },
      {
      "gId": 3,
      "gName": "Pencil",
      "gPrice": 5,
      "gQuantity": 480
   }
]
```

----------------------------------------------------------------

#### Get single item : ***GET***

```http
  GET /v1/grocery/{id}
```

Sample GET Single Item URL : 

```http
http://localhost:8080/v1/grocery/2

```


| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Header Parameter : username` | `string` | **Required** |
| `id`      | `int` | **Required** |


returns json response as below : 

```bash
{
   "gId": 2,
   "gName": "Pen",
   "gPrice": 10,
   "gQuantity": 480
}
```

----------------------------------------------------------------

#### Adding an item : ***POST*** 

```http
  POST /v1/grocery/
```

| Parameter | Type     | Description                       | Additional Info |
| :-------- | :------- | :-------------------------------- | :---------- |
| `Header Parameter : username` | `string` | **Required** | Must have Admin role |
| `Json Request Body`      | `application/json` | **Required** | gId parameter ***is not mandatory*** in request body |

Sample POST Request Body : 

```bash
{
      "gName": "BoltFit Bottle",
      "gPrice": 250,
      "gQuantity": 36
}
```

Sample Response after successful POST/ additional : 

```bash
{
   "added_item": "GroceryItem{gId='4', gName='BoltFit Bottle', gPrice=250.0, gQuantity=36}",
   "status": "Addition of Grocery Item is successful"
}
```

----------------------------------------------------------------

#### Updating an item : ***PUT***

```http
  PUT /v1/grocery/
```

| Parameter | Type     | Description                       | Additional Info |
| :-------- | :------- | :-------------------------------- | :---------- |
| `Header Parameter : username` | `string` | **Required** | Must have Admin role |
| `Json Request Body`      | `application/json` | **Required** | gId parameter ***is mandatory*** in request body |

Sample PUT Request Body : 

```bash
{
      "gId": 2,
      "gName": "Pen",
      "gPrice": 10,
      "gQuantity": 500
}
```

Sample Response after successful PUT/ updating : 

```bash
{
   "updated_item": "GroceryItem{gId='2', gName='Pen', gPrice=10.0, gQuantity=500}",
   "status": "Updation of Grocery Item is successful"
}
```


----------------------------------------------------------------

#### Deleting an item : ***DELETE***

```http
  DELETE /v1/grocery/{id}
```

Sample URL for Deleting Single Item : 

```http
http://localhost:8080/v1/grocery/2

```

| Parameter | Type     | Description                       | Additional Info |
| :-------- | :------- | :-------------------------------- | :---------- |
| `Header Parameter : username` | `string` | **Required** | Must have Admin role |
| `id`      | `int` | **Required** | -- |


Sample Response after successful POST/ additional : 

```bash
{
   "deleted_item": "GroceryItem{gId='4', gName='BoltFit Bottle', gPrice=250.0, gQuantity=36}",
   "status": "Deletion of Grocery Item with id = 4 is successful"
}
```


----------------------------------------------------------------



## Tech Stack

**Backend :** Java : 8

**Framework for Rapid Development :** Spring Boot : 2.4.1

**Dependency Management :** Maven : 3.8.1

**Database :** MySQL : 5.7

**Server :** Docker 


----------------------------------------------------------------

## Support

For support, email patil4x4sanket@gmail.com

----------------------------------------------------------------


## Author

- Sanket Patil : patil4x4sanket@gmail.com



