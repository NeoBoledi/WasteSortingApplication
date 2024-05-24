
# Waste Sorting Application API Documentation

Welcome to the API documentation for the Waste Sorting Application developed by Neo Boledi Magolela. 
This guide provides detailed information on the REST endpoints required for smooth interaction between
the frontend and backend systems of the application.

# Introduction

The Waste Sorting Application is designed to educate and help individuals and communities practice 
eco-friendly waste disposal. With this API, users can learn about different types of waste, how to dispose
of them correctly, and get recycling advice. The endpoints listed below ensure smooth data flow, making it 
easy for users to engage with the application.

## Categories Endpoints

#### Add Category
Endpoint: http://localhost:6062/api/v1/category/save
- **Method**: POST
- **Description**: Add a new waste category.
- **Response**:
    - **Status Code**: 201 CREATED
      ![](documentation-pictures/addCategory.png)

#### List All Categories
Endpoint: http://localhost:6062/api/v1/category/all
- **Method**: GET
- **Description**: Retrieve all available waste categories.
- **Response**:
    - **Status Code**: 200 OK
      ![](documentation-pictures/getAllCategories.png)

#### Get Category by ID
Endpoint: http://localhost:6062/api/v1/category/{id}
- **Method**: GET
- **Description**:Retrieve a waste category by its ID.
- **Response**:
    - **Status Code**: 200 OK

  ![](documentation-pictures/getByCategoryId.png)

#### Get Category by Name
Endpoint: http://localhost:6062/api/v1/category/find/{name}
- **Method**: GET
- **Description**: Retrieve a waste category by its name.
- **Response**:
    - **Status Code**: 200 OK

![](documentation-pictures/getByCategoryId.png)

#### Update Categry
Endpoint: http://localhost:6062/api/v1/category/update/{id}
- **Method**: PUT
- **Description**: Update a waste category by it ID
- **Response**:
    - **Status Code**: 200 OK

  ![](documentation-pictures/updateCategory.png)

#### Delete Category
Endpoint: http://localhost:6062/api/v1/category/delete/{id}
- **Method**: DELETE
- **Description**:Delete a waste category by its ID.
- **Response**: 204 No Content

  ![](documentation-pictures/deleteCategory.png)



## Guidelines Endpoints


#### Add Guideline
Endpoint: http://localhost:6062/api/v1/guideline/{wasteCategoryId}
- **Method**: POST
- **Description**:Add a new disposal guideline.
- **Response**:
    - **Status Code**: 201 CREATED

      ![](documentation-pictures/addGuideline.png)

#### List all Guidelines
Endpoint: http://localhost:6062/api/v1/guideline/all
- **Method**: GET
- **Description**: Retrieve all disposal guidelines.
- **Response**:
    - **Status Code**: 200 OK

      ![](./documentation-pictures/getAllGuidelines.png)

#### Get Guideline by ID
Endpoint: http://localhost:8080/api/v1/guideline/find/{id}
- **Method**: GET
- **Description**:Retrieve a disposal guideline by its ID.
- **Response**:
    - **Status Code**: 200 OK

  ![](./documentation-pictures/getByGuidelineId.png)

#### Update Guideline
Endpoint: http://localhost:6062/api/v1/guideline/update/{id}/{wasteCategoryId}
- **Method**: PUT
- **Description**:Update a disposal guideline by its ID.
- **Response**:
    - **Status Code**: 200 OK

      ![](./documentation-pictures/updateGuideline.png)

#### Delete Guideline
Endpoint: http://localhost:6062/api/v1/guidelines/delete/{id}
- **Method**: DELETE
- **Description**: Delete a disposal guideline by its ID.
- **Response**:
    - **Status Code**: 204 No Content

      ![](./documentation-pictures/deleteGuideline.png)




## Recycling Tips Endpoints


#### Add tip endpoint
Endpoint: http://localhost:6062/api/v1/tips/{wasteCategoryId}
- **Method**: POST
- **Description**: Add a new recycling tip.
- **Response**:
    - **Status Code**: 201 CREATED

      ![](./documentation-pictures/addTip.png)

#### List All Tips
Endpoint: http://localhost6062/api/v1/tips/all
- **Method**: GET
- **Description**: get all recycling tips.
- **Response**:
    - **Status Code**: 200 OK

      ![](documentation-pictures/getAllTips.png)

#### Get Tip by ID
Endpoint: http://localhost:6062/api/v1/tips/find/{id}
- **Method**: GET
- **Description**:Retrieve a recycling tip by its ID.
- **Response**:
    - **Status Code**: 200 OK

      ![](./documentation-pictures/getByTipId.png)


#### Update Tip
Endpoint: http://localhost:6062/api/v1/tips/update/{id}/{wasteCategoryId}
- **Method**: PUT
- **Description**: Update a recycling tip by its ID.
- **Response**:
    - **Status Code**: 200 OK

      ![](./documentation-pictures/updateTip.png)

#### Delete Tip
Endpoint: http://localhost:6062/api/v1/tips/delete/{id}
- **Method**: DELETE
- **Description**:delete recycling tip by id.
- **Response**:
    - **Status Code**: 204 No Content

      ![](./documentation-pictures/deleteTip.png)







