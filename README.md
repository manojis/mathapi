# mathapi

## Steps for build and running

 - mvn clean install
 - mvn spring-boot:run

### Curl requests


### min
```
curl --location --request GET 'http://localhost:8080/min' \
--header 'Content-Type: application/json' \
--data-raw '{
"input":[1,2,4,8,5,9,7,1,12],
"quantifier": 3
}'
```

### max
```
curl --location --request GET 'http://localhost:8080/max' \
--header 'Content-Type: application/json' \
--data-raw '{
"input":[1,2,4,8,5,9,7,1,12],
"quantifier": 4
}'
```

### average
```
curl --location --request GET 'http://localhost:8080/avg' \
--header 'Content-Type: application/json' \
--data-raw '{
"input":[1,2,4,8,5,9,7,1,12]
}'
```

### median
```
curl --location --request GET 'http://localhost:8080/median' \
--header 'Content-Type: application/json' \
--data-raw '{
"input":[1,2,4,8,5,9,7,1,12]
}'
```

###Percentile
```
curl --location --request GET 'http://localhost:8080/percentile' \
--header 'Content-Type: application/json' \
--data-raw '{
"input":[1,2,4,8,5,9,7,1,12],
"quantifier": 95
}'
```