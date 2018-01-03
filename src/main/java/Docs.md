# JSON
## Requests
### /new
```json
{
  "name" : "YOUR_NICKNAME"
}
```
### /update
```json
{
  "token" : "TOKEN",
  "score" : "NEW_SCORE"
}
```

### /start
```json
{
  "token" : "TOKEN"
}
```

## Response (at code = 2XX)
### /new
```json
{
  "name" : "YOUR_NICKNAME"
}
```
### /update
```json
{
  "token" : "TOKEN",
  "score" : "NEW_SCORE"
}
```

### /start
```json
{
  "token" : "TOKEN"
}
```

# Status codes

## /new
### 200
Successfully created user. Token is in return body

### 401
User with that name already exists

### 402
Name field was empty

### 550
General exception

### 555
IOException

### 560
General exception in HTTP communication (when everything else fails)

## /update
### 200
Successfully updated score. Return body is highscore

### 201
Not new highscore, so did not update that, but returning highscore as body

### 401
No user with that token

### 402
Token and/or score variables where empty/less than 0

### 550
General exception

### 555
IOException

### 560
General exception in HTTP communication (when everything else fails)

## /start
### 200
Successfully updated start value

### 401
No user with that token
    
### 402
Token variable was empty

### 550
General exception

### 555
IOException

### 560
General exception in HTTP communication (when everything else fails)
