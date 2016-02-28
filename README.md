# GoEuroTest

This is a test for fetching results from a service and writing the results in a CSV file.

# Dependencies

You will need to set target compliance and library to JRE 8.

# Assemble it

All you need to do is run the following command:

```
mvn assembly:assembly
```

# Run it

In target folder just run this command:

```
java -jar simpleapp-{version}-jar-with-dependencies.jar [CITY_NAME]
```

# Example

```
java -jar simpleapp-0.0.1-jar-with-dependencies.jar "Berlin"
```

