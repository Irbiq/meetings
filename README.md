# meetings
# client 
|command|description|
|---|---|
|`npm install`| Install all dependencies|
|`npm run start`| Run client dev_server on the port: 8089|
|`npm run build`|	Create bundled files|

# server
>Runs on the port: 8080

# Meetings API 

## Adds booking request to the database table `booking_requests`  
* **URL**

  `api/booking/add`   
* **Method**

  `POST`
* **BODY**
```json
{
    "id": 0,
    "employee": "EMP1",
    "requestTime": "2017-09-03 16:27:32",
    "meetingTime": "2017-09-03 04:09:00",
    "meetingDuration": 1
}
```
## Adds booking request to the database table `booking_requests`, converts request to meeting and adds it to table `meetings` if it satisfies the conditions.  
* **URL**

  `api/meeting/add/request`   
* **Method**

  `POST`
* **BODY**
```json
{
    "id": 0,
    "employee": "EMP1",
    "requestTime": "2017-09-03 16:27:32",
    "meetingTime": "2017-09-03 04:09:00",
    "meetingDuration": 1
}
```







