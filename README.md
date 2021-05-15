# nothingHandler

# Goal

In case null, empty or blank condition checking:

* Enhance readability
* Enhance compression
* Avoid duplication

# Areas of using

| Checking value | Object | Collection | String |
|----------------|--------|------------|--------|
| null           | X      | X          | X      |
| empty          | -      | X          | X      |
| blank          | -      | -          | X      |

# Using way

## In case NULL

### Null checking

```java
if(object==null){
        throw new AnyException();
        }
```

```java
NothingHandler.ifNull(object).thenThrow(new AnyException());
```

### Not Null checking

```java
if(object!=null){
        throw new AnyException();
        }
```

```java
NothingHandler.ifNotNull(object).thenThrow(new AnyException());
```

### Read value if Not Null

```java
if(object!=null){
        return object;
        }else{
        retrun otherObject;
        }
```

```java
retrun NothingHandler.ifNotNull(object).else(otehrObject);
```